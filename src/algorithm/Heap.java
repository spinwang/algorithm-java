package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by spin on 2/27/17.
 */
public class Heap {
    public static int[] kSmallest(int[] array, int k){
        if (array.length == 0 || k == 0){
            return new int[0];
        }


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                if (t0.equals(t1)){
                    return 0;
                }
                return t0 > t1 ? -1 : 1;
            }
        };

        PriorityQueue<Integer> maxHeap  = new PriorityQueue<Integer>(k, comparator);
        // push k into the max heap
        for (int i = 0; i<k; i++){
            maxHeap.offer(array[i]);
        }

        for (int j=k; j<array.length; j++){
            Integer max = maxHeap.peek();
            // new number is smaller than the max of the heap
            if (max > array[j]){
                maxHeap.poll();
                maxHeap.offer(array[j]);
            }
        }
        int[] result = new int[k];
        for (int x = k-1; x >=0; x--){
            result[x] = maxHeap.poll();
        }
        return result;

    }
}
