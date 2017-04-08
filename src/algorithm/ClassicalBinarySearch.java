package algorithm;

/**
 * Created by spin on 2/15/17.
 */
public class ClassicalBinarySearch {

    public int binarySearch(int[] array, int target){
        if (array == null || array.length<1){
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        ClassicalBinarySearch solution = new ClassicalBinarySearch();
        int[] ary1 = {1, 2, 3, 4, 5};
        int[] ary2 = {1, 2, 2, 2, 3, 4};
        Util.print(solution.binarySearch(ary1,2));
        Util.print(solution.binarySearch(ary2, 2));
    }
}
