package algorithm;

/**
 * Created by spin on 3/8/17.
 */
public class StringManipulation {
    public static String replace(String input, String s, String t){

        char[] array = input.toCharArray();
        if (s.length() >= t.length()){
            return replaceWithShorter(array, s, t);
        } else {
            return replaceWithLonger(array, s, t);
        }
    }

    private static String replaceWithShorter(char[] array, String s, String t){

        int slow = 0;
        int fast = 0;
        int stringLength = s.length();
        int newStringLength = t.length();
        while (fast < array.length){
            if (equalSubString(array, s, fast)){

                // add the new string
                copySubString(array, t, slow);
                // move the fast pointer
                fast += stringLength;
                // move the slow pointer
                slow += newStringLength;

            } else {
                array[slow] = array[fast];
                slow++;
                fast++;

            }
        }


        return new String(array);
    }

    // copy string t to char array and start at index
    private static void copySubString(char[] array, String t, int index){
        for (int i = 0; i < t.length(); i++){
            array[index + i] = t.charAt(i);
        }
    }

    private static String replaceWithLonger(char[] array, String s, String t){
        int slow = 0;
        int fast = 0;
        int stringLength = s.length();
        int newStringLength = t.length();

        // number of times the pattern happens
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (equalSubString(array, s,i)){
                count++;
            }
        }

        int newLength = count + array.length;
        char[] newArray = new char[newLength];

        while (slow < stringLength) {
            if (equalSubString(array,t, slow)) {
                copySubString(newArray, t, slow);
                slow += stringLength;
                fast += newStringLength;
            } else {
                newArray[fast] = array[slow];
                fast++;
                slow++;
            }
        }


        return new String(newArray);
    }

    private static boolean equalSubString(char[] input, String s, int index){
        int stringLength = s.length();
        int inputLength = input.length;

        // index out of bound

        if ((index + stringLength - 1) > (inputLength - 1)) {
            return false;
        }
        for (int i = index; i< (index + stringLength); i++){
            if (input[i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

    }
}
