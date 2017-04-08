package algorithm;

import java.util.*;

/**
 * Created by spin on 2/27/17.
 */
public class DFS {

    public void bracket(int n, int l, int r, String[] soluPrefix) {
        if ((l + r) == 2 * n) {
            return;
        }
        if (l < r) {
            return;
        }

        bracket(n, l + 1, r, soluPrefix);

        bracket(n, l, r + 1, soluPrefix);

    }

    public static List<List <Integer>> coin(int money, int[] choices) {

        List<Integer> coinNums = new ArrayList<Integer>();
        List<List <Integer>> solution = new ArrayList<List<Integer>>();
        coinHelper(choices, money, 0, coinNums, solution);
        return solution;
    }

    public static void coinHelper(int[] choices, int moneyLeft, int level, List<Integer> coinNums, List<List<Integer>> solution) {

        int coin = choices[level];
        if (level == (choices.length - 1)) {
            if (moneyLeft % coin == 0){
                coinNums.add(moneyLeft/coin); // use the smallest coin for all the money left
                solution.add(new ArrayList<Integer>(coinNums));
                coinNums.remove(coinNums.size() - 1);
            }
            return;
        }

        int maxCoinNum = moneyLeft / coin;
        for (int num = 0; num <= maxCoinNum; num++) {
            coinNums.add(num);
            coinHelper(choices, moneyLeft - num * coin, level + 1, coinNums, solution);
            coinNums.remove(coinNums.size() -1);
        }
    }

    // n pairs of parenthese
    public static List<String> validParentheses(int n){
         int levelLimit = 2* n;
         List<String> solution = new ArrayList<String>();
         char[] cur = new char[levelLimit];
         validParenthesesHelper(0, 0,0, cur,solution,levelLimit);
         return solution;
    }

    private static void validParenthesesHelper(int level, int l, int r, char[] cur, List<String> solution, int levelLimit){
        // base case
        if (level == levelLimit){
            String soln = new String(cur);
            solution.add(soln);
            Util.print(soln);
            return;
        }

        if ( l < (levelLimit/2) ){
            cur[level] = '(';
            validParenthesesHelper(level+1, l+1, r, cur, solution,levelLimit);
            // should have removed ( from cur, but this is an array, thus no need
        }

        if ( l > r){
            cur[level] = ')';
            validParenthesesHelper(level+1, l, r+1, cur, solution,levelLimit);

        }
    }

    public static List<String> subSets(String set){
        return null;
    }

    public static void subSetsHelper(){
    }

    public static void main(String[] args){
        int target = 11;
        int[] money = {5,2,1};
        List<List <Integer>> solution = coin(target,money);

        validParentheses(6);
    }
}
