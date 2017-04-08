package algorithm;


public class MaxSumPathBwtLeaves {
    public int maxSumPathBwtLeaves(TreeNode root){
        if (root == null){
            return 0;
        }

        // use this to save the max so far
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        // recursively go through every node
        // no need to capture the return value, since it’s the int[] max that holds the max sumpath
        maxSumPathToLeaf(root, max);

        return max[0];

    }

    private int maxSumPathToLeaf(TreeNode node, int[] max){
        // this is a leaf node
        if (node == null){
            return 0; // choose 0, since this wil be change the sum
        }

        int maxLeftSum = maxSumPathToLeaf(node.left, max);
        int maxRightSum = maxSumPathToLeaf(node.right, max);

        if (node.left != null && node.right != null){
            max[0] = Math.max(max[0], node.key + maxLeftSum + maxRightSum);
            return node.key + Math.max(maxLeftSum, maxRightSum);
        }

        if (node.left != null){
            return node.key + maxLeftSum;
        } else {
            return node.key + maxRightSum;
        }
    }
}
