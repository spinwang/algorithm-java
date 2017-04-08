package algorithm;

import java.util.*;

// Time: O(N*N!)
// Space: O(LogN)
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        if (n<=0){
            return null;
        }
        // store all the possible solution
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();

        // store the current solution in the DFS
        List<Integer> currentSolution = new ArrayList<Integer>();
        nQueensHelper(n, 0, currentSolution, solutions);
        return solutions;
    }

    private void nQueensHelper(int n, int row, List<Integer> currentSolution, List<List<Integer>> solutions) {
        if (row == n) {
            solutions.add(new ArrayList<Integer>(currentSolution));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (canPut(row, col, currentSolution)) {
                //System.out.println(col);
                currentSolution.add(col);
                nQueensHelper(n, row + 1, currentSolution, solutions);
                currentSolution.remove(currentSolution.size() - 1);
            }
        }
    }

    private boolean canPut(int row, int col, List<Integer> currentSolution) {

        for (int i = 0; i < currentSolution.size(); i++) {
            int preCol = currentSolution.get(i);
            if ( (col == preCol) || Math.abs(col-preCol) == Math.abs(row-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueens solution = new NQueens();
        List<List<Integer>> results = solution.nqueens(8);
        Util.print(results);
    }
}
