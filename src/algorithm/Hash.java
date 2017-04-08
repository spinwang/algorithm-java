package algorithm;

import java.util.*;

/**
 * Created by spin on 3/5/17.
 */




public class Hash {
    public static String[] topKFrequent(String[] combo, int k) {

        if (combo == null || k < 1) {
            return null;
        }

        Map<String, Integer> freqMap = new HashMap<String, Integer>();

        // populate the hashmap
        for (String s : combo) {
            Integer count = freqMap.get(s);
            if (count == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, count + 1);
            }
        }

        // define the comparator for the minHeap
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                Integer entry1Val = entry1.getValue();
                Integer entry2Val = entry2.getValue();
                if (entry1Val == entry2Val) {
                    return 0;
                }
                return entry1Val < entry2Val ? -1 : 1;
            }
        };

        // set up a pq to find the largest k entries in the hashtable
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, comparator);
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                Map.Entry<String, Integer> curMin = minHeap.peek();
                // insert into the heap if entry larger than the smallest of the minHeap
                if (entry.getValue() > curMin.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        // return the heap in a string[]
        int size = minHeap.size();
        String[] result = new String[size];
        for (int j = size -1; j >=0; j--) {
            result[j] = minHeap.poll().getKey();
        }

        return result;

    }


    public static int missingInt(int[] array){
        if(array == null){
            return -1;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        // insert all numbers in the array into the hashset
        for (int i = 0; i<array.length; i++){
            set.add(array[i]);
        }

        // loop through the possible numbers to find which one is not there
        for (int j =1; j<= (array.length + 1); j++){
            if (!set.contains(j)){
                return j;
            }
        }

        return array.length + 1;
    }

    public static void main(String[] args){
        String[] res = topKFrequent(new String[]{"a","a","b"},1);
        Util.print(res);

        int missing1 = missingInt(new int[]{2,1,4});
        int missing2 = missingInt(new int[]{});
        Util.print(missing1);
        Util.print(missing2);
    }

}
