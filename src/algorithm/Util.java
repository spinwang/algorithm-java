package algorithm;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(long num) {
        System.out.println(num);
    }

    public static void print(boolean bool) {
        System.out.println(bool);
    }

    public static void print(String[] strings){
        System.out.println(Arrays.toString(strings));
    }

    public static void print(String string){
        System.out.println(string);
    }

    public static void print(List<List<Integer>> list2D) {
        for (int i =0; i<list2D.size(); i++){
            System.out.println(list2D.get(i));
        }
    }
}
