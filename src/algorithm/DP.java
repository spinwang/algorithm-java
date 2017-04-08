package algorithm;

public class DP {
    public static int largestSubarraySum(int[] nums){
        int[] m = new int[nums.length];
        m[0] = nums[0];
        int globalMax = m[0];

        for (int i = 1; i < m.length; i++ ){
            if (m[i-1] < 0){
                m[i] = nums[i];
            } else {
                m[i] = m[i-1] + nums[i];
            }

            if (m[i] > globalMax){
                globalMax = m[i];
            }

        }
        return globalMax;
    }

    /**
     *  a   b    c    d
     *    1    2    3    4 ..... --> m's index
     *
     */
    public int minCutsPalindromes(String input){
        if (input == null){
            return 0;
        }

        char[] ary = input.toCharArray();
        int len = ary.length;
        if (len == 0){
            return 0;
        }
        int[] m = new int[len+1];

        for (int end = 1; end<=len; end++){
            m[end] = end - 1;
            for(int start = end; start>=1; start--){
                if (isP(ary,start,end-1)){
                    m[end] = Math.min(m[end], 1 + m[start]);
                }
            }
        }

        return m[len];
    }

    /**
     *  a     b   c   d
     * left         right
     */
    private boolean isP(char[] ary, int left, int right){
        if (left >= right){
            return true;
        }

        if (ary[left] == ary[right]){
            return isP(ary, left+1, right-1);
        } else {
            return false;
        }
    }
}
