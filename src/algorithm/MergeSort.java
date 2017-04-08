package algorithm;

import java.util.Arrays;

/**
 * Created by spin on 2/12/17.
 */
public class MergeSort {

    private static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    public int[] mergeSort(int[] array){
        if (array == null || array.length < 1){
            return array;
        }
        array = mergeSort(array, 0, array.length-1);
        return array;
    }

    private int[] mergeSort(int[] args, int left, int right) {
        // terminate condition to stop the recursive

        if (left == right) {
            return new int[]{args[left]};
        }

        // recursive call
        int mid = left + (right - left) / 2;
        int[] ary1 = mergeSort(args, left, mid);
        int[] ary2 = mergeSort(args, mid + 1, right);
        int[] result = combine(ary1, ary2);
        return result;
    }


    private static int[] combine(int[] ary1, int[] ary2) {
        int len1 = ary1.length;
        int len2 = ary2.length;
        int[] ary = new int[len1 + len2];
        int i = 0, j = 0;
        while (i < len1 || j < len2) {

            if (i == len1 && j < len2) {
                ary[i + j] = ary2[j];
                j++;
            } else if (j == len2 && i < len1) {

                ary[i + j] = ary1[i];
                i++;
            } else if (ary1[i] < ary2[j]) {

                ary[i + j] = ary1[i];
                i++;

            } else {
                ary[i + j] = ary2[j];
                j++;
            }

        }
        return ary;
    }

    public static void main(String[] args){
        MergeSort solution = new MergeSort();


        int[] ary1 = new int[]{1, 5, 2, 7, 4, 13, 11};
        int[] ary2 = new int[0];
        int[] ary3 = null;
        System.out.println("mergeSort");
        print(solution.mergeSort(ary1));
        print(solution.mergeSort(ary2));
        print(solution.mergeSort(ary3));
    }
}
