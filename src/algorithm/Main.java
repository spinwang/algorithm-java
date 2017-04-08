package algorithm;

import java.util.Arrays;

public class Main {

    private static void selectionSort(int[] ary) {
        int global_min_index, tmp;
        for (int i = 0; i < ary.length; i++) {
            global_min_index = i;
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[j] < ary[global_min_index]) {
                    global_min_index = j;
                }
            }

            tmp = ary[global_min_index];
            ary[global_min_index] = ary[i];
            ary[i] = tmp;
        }
    }

    private static int[] mergeSort(int[] args, int left, int right) {
        // determinate condition to stop the recursive

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
        print(ary);
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

    private static void quickSort(int[] ary, int left, int right) {

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
                int tmp = ary[j];
                ary[j] = ary[i];
                ary[i] = tmp;
                j--;
            }
        }

        int tmp = ary[i];
        ary[right] = tmp;
        ary[i] = pivot;


        quickSort(ary, left, i - 1);
        quickSort(ary, i + 1, right);
    }

    public static void quickSort(int[] ary) {
        quickSort(ary, 0, ary.length - 1);
        // return ary;
    }

    public static void rainbowSort(int[] ary) {
        if (ary == null) {
            return;
        }
        if (ary.length < 2) {
            return;
        }

        int i = 0, j = 0, k = ary.length - 1;
        while (j <= k) {
            if (ary[i] == -1) {
                i++;
                j++;
            } else if (ary[i] == 0) {
                swap(ary, i, j);
                j++;
            } else if (ary[i] == 1) {
                swap(ary, i, k);
                k--;
            }
        }
    }

    private static void swap(int[] ary, int i, int j) {
        int tmp = ary[i];
        ary[i] = ary[j];
        ary[j] = tmp;
    }

    public int binarySearh(int[] array, int target){
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        return 0;

    }

    public static void pushZerosToRight(int[] ary) {
        if (ary == null) {
            return;
        }
        if (ary.length < 2) {
            return;
        }
        int i = 0, j = ary.length - 1;
        while (i <= j) {
            if (ary[i] == 0) { // move zero to the right
                int tmp = ary[i];
                ary[i] = ary[j];
                ary[j] = tmp;
                j--;
            } else {
                i++;
            }
        }
    }


    private static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    public static void main(String[] args) {
        String s = "d";
        String ss = "dd";
        Util.print( s + ss);


        int[] ary = new int[6];
        int[] ary1 = new int[]{1, 5, 2, 7, 4, 13, 11};
        for (int i = 0; i < ary.length; i++) {
            ary[i] = ary.length - 1 - i;
        }


        print(ary);
        selectionSort(ary);
        print(ary);


        System.out.println("combine");
        int[] aryA = new int[]{1, 4};
        int[] aryB = new int[]{2, 3};
        print(combine(aryA, aryB));

        System.out.println("mergeSort");
        print(ary1);
        int[] ary1_sorted = mergeSort(ary1, 0, ary1.length - 1);
        print(ary1_sorted);


        System.out.println("quickSort");
        int[] aryC = new int[]{1, 4, 2, 3, 9, 6, 1, 0};
        print(aryC);
        quickSort(aryC);
        print(aryC);


        System.out.println("pushZeroesToRight");
        int[] aryD = new int[]{1, 0, 2, 0, 9, 6, 1, 0};
        print(aryD);
        pushZerosToRight(aryD);
        print(aryD);

        int i = 1;
        System.out.println(i++);

        System.out.println("rainbowSort");
        int[] aryE = new int[]{1, 0, 1, 0, 0, -1, 1, 0};
        int[] aryF = new int[]{1, 0, 1, 1, -1, 1, 0};
        int[] aryG = new int[]{1, 1, 1, -1, 1, 1};
        rainbowSort(aryE);
        rainbowSort(aryF);
        rainbowSort(aryG);
        print(aryE);
        print(aryF);
        print(aryG);

        System.out.println("start");
        System.out.println("\r\n");
        System.out.println("stop");

        int hey = 0;
        System.out.println(hey++);
        System.out.println(++hey);


        int n = 20;
        boolean isPrime = true;
        for (int z = 2; z * z < n; z++) {
            if (n % z == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime);

        System.out.println("GCD");
        int x = 147, y = 105;
        while ( x != y){
            if (x>y){
                x = x-y;
            } else {
                y = y-x ;
            }
        }
        System.out.println(x);
        for (int a = 1; a < 1000000; a++){
            if ( a % 2 == 1 &&
                 a % 3 == 0 &&
                 a % 4 == 1 &&
                 a % 5 == 4 &&
                 a % 6 == 3 &&
                 a % 7 == 0 &&
                 a % 8 == 1 &&
                 a % 9 == 0   ){
                System.out.println(a);
                break;
            }

        }

    }
}


