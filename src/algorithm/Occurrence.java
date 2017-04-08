package algorithm;

/**
 * Created by spin on 2/15/17.
 */
public class Occurrence {
    public int firstOccur(int[] array, int target){
        
        if (array == null || array.length < 1){
            return -1;
        }

        
        int left = 0;
        int right = array.length - 1;


        if (array[left] > target){
            return -1;
        }

        if (array[left] == target){
            return left;
        }

        while ( left < right ){
            int mid = left + (right-left)/2;

            if (array[mid] == target){
                right = mid;
            } else if (array[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target){
            return left;
        } else if (array[right] == target){
            return right;
        } else {
            return -1;
        }

    }

    public int lastOccur(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }


        int left = 0;
        int right = array.length - 1;

        while (left < right - 1){
            int mid = left + (right-left)/2;
            if (array[mid] == target){
                left = mid;
            } else if (array[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[right] == target){
            return right;
        } else if (array[left] == target){
            return left;
        } else {
            return -1;
        }
    }

  

    public static void main(String[] args){
        Occurrence solution = new Occurrence();

        int[] ary1 = {1, 2, 3};
        int[] ary2 = {1, 2, 2, 2, 3};
        int[] ary3 = {1,2};
        Util.print(solution.firstOccur(ary1,2) == 1);
        Util.print(solution.firstOccur(ary1,3) == 2);
        Util.print(solution.firstOccur(ary2,2) == 1);
        Util.print(solution.firstOccur(ary3,0) == -1);
        Util.print(solution.firstOccur(ary3,3) == -1);

        Util.print(solution.lastOccur(ary1,2) == 1);
        Util.print(solution.lastOccur(ary1,3) == 2);
        Util.print(solution.lastOccur(ary2,2) == 3);
        Util.print(solution.lastOccur(ary3,0) == -1);
        Util.print(solution.lastOccur(ary3,3) == -1);

    }
}
