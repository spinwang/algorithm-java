package algorithm;

import java.util.Arrays;

/**
 * Created by spin on 2/14/17.
 */
public class MoveZero {
    private static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    public int[] moveZero(int[] array){
        if (array == null) {
            return array;
        }
        if (array.length < 2) {
            return array;
        }
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (array[i] == 0) { // move zero to the right
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                j--;
            } else {
                i++;
            }
        }
        return array;
    }
    
    public static void main(String[] args){
        MoveZero solution = new MoveZero();
        int[] aryD = new int[]{1, 0, 2, 0, 9, 6, 1, 0};
        print(solution.moveZero(aryD));
    }
}
