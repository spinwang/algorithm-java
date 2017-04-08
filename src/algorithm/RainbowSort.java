package algorithm;

import java.util.Arrays;

/**
 * Created by spin on 2/13/17.
 */
public class RainbowSort {

    private static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    public int[] rainbowSort(int[] array){
        if (array == null || array.length < 2) {
            return array;
        }

        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[k] == 1) {
                k--;
            } else if (array[i] == -1) {
                if (i == j) {
                    j++;
                    j++;
                } else {
                    i++;
                }
            } else if (array[i] == 0) {
                swap(array, i, j);
                j++;
            } else if (array[i] == 1) {
                swap(array, i, k);
                k--;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
    public static void main(String[] args){
        RainbowSort solution = new RainbowSort();
        int[] aryA = new int[]{1, -1};
        int[] aryB = new int[]{-1,0,0,1,1};
        int[] aryC = new int[]{1,1,1};
        int[] aryE = new int[]{1, 0, 1, 0, 0, -1, 1, 0};
        int[] aryF = new int[]{1, 0, 1, 1, -1, 1, 0};
        int[] aryG = new int[]{1, 1, 1, -1, 1, 1};
        int[] aryD = new int[]{1,0,-1,-1,1,0};
        print(solution.rainbowSort(aryA));
        print(solution.rainbowSort(aryB));
        print(solution.rainbowSort(aryC));
        print(solution.rainbowSort(aryD));
        print(solution.rainbowSort(aryE));
        print(solution.rainbowSort(aryF));
        print(solution.rainbowSort(aryG));
    }
}
