package algorithm;

import java.util.*;

public class BinaryTree {
    public List<Integer> inOrderTrasverseRecursive(TreeNode root){
        ArrayList<Integer> ary = new ArrayList<Integer>();
        TreeNode leftNode = root.left;
        while (leftNode != null){
            leftNode = leftNode.left;
        }
        return ary;
    }

    public List<Integer> preOrderTrasverseIterative(TreeNode root){
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null){
            return preorder;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){

            TreeNode node = stack.pollFirst();
            preorder.add(node.key);

            if ( root.right != null ){
                stack.offerFirst(node.right);
            }

            if ( root.left != null ){
                stack.offerFirst(node.left);
            }
        }
        return preorder;
    }

    public List<Integer> inOrderTrasverseIterative(TreeNode root){
        List<Integer> inorder = new ArrayList<Integer>();
        if (root == null){
            return inorder;
        }

        Deque<Integer> stack = new LinkedList<Integer>();

        
        return inorder;
    }

    public boolean isBST(TreeNode root){
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode node, int min, int max){
        if ( node == null ){
            return false;
        }

        if ( node.key <= min || node.key >= max){
            return false;
        }

        return isBSTHelper(node.left, min, node.key) &&
                isBSTHelper(node.right, node.key, max);
    }


    public boolean isComplete(TreeNode root){
        if (root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean hasEmptyBefore = false;

        // Breadth first search
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            // the order here matters a lot
            if (node.left == null ){
                hasEmptyBefore = true;
            } else if ( hasEmptyBefore ){
                return false;
            } else {
                queue.offer(node.left);
            }

            if (node.right == null ){
                hasEmptyBefore = true;
            } else if ( hasEmptyBefore ){
                return false;
            } else {
                queue.offer(node.right);
            }

        }

        return true;
    }

    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }

        return false;

    }

    public List<List<Integer>> layerByLayer(TreeNode root){


        List<List<Integer>> layers = new ArrayList<List<Integer>>();


        if (root==null){
            return layers;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int queueSize = queue.size();

            List<Integer> layer = new ArrayList<Integer>();

            for (int i = 0; i < queueSize; i++){

                TreeNode node = queue.poll();

                layer.add(node.key);

                if ( node.left != null ) {
                    queue.offer(node.left);
                }
                if ( node.right != null ) {
                    queue.offer(node.right);
                }

            }

            layers.add(layer);
        }

        return layers;
    }

    public int maxPathBetweenLeaf(TreeNode root){
        if (root == null){
            return 0;
        }

        int[] max = new int[1];

        maxPathToLeafHelper(root,max);

        return max[0];

    }

    public int maxPathToLeafHelper(TreeNode root, int[] max){
        // already leaf node
        if (root == null){
            return 0;
        }

        int left = maxPathToLeafHelper(root.left, max);
        int right = maxPathToLeafHelper(root.right, max);

        // when root has left node and right node, calculate the max path
        // and check if this is larger than the global max, which is saved in max[0]
        if (root.left != null && root.right != null){
            max[0] = Math.max(left + right + root.key, max[0]);
            return Math.max(left, right) + root.key;
        }

        return root.left == null ? (left + root.key) : (right + root.key);

    }

    public static void main(String[] args){

    }

}


