package algorithm;

import java.util.Arrays;

public class QuickSort {

    private static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    private void quickSort(int[] ary, int left, int right) {

        if (ary == null) {
            return;
        }

        if (left >= right) {
            return;
        }

        int i = left, j = right - 1, pivot = ary[right];

        while (i <= j) {
            if (ary[i] <= pivot) {
                i++;
            } else {
                swap(ary, i,j);
                j--;
            }
        }

        swap(ary, i, right);

        quickSort(ary, left, i - 1);
        quickSort(ary, i + 1, right);
    }

    private void swap(int[] ary, int a, int b){
        int tmp = ary[a];
        ary[a] = ary[b];
        ary[b] = tmp;
    }

    public int[] quickSort(int[] ary) {
        if (ary == null || ary.length < 1) {
            return ary;
        }
        quickSort(ary, 0, ary.length - 1);
        return ary;
    }

    public static void main(String[] args){

        QuickSort solution = new QuickSort();

        System.out.println("quickSort");
        int[] ary1 = new int[]{1, 4, 2, 3, 9, 6, 1, 0};
        int[] ary2 = new int[0];
        int[] ary3 = null;
        print(solution.quickSort(ary1));
        print(solution.quickSort(ary2));
        print(solution.quickSort(ary3));
    }
}
