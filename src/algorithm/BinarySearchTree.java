package algorithm;

/**
 * Created by spin on 3/9/17.
 */
public class BinarySearchTree {
    public static TreeNode insert(TreeNode root, int key){
        return null;
    }

    public static TreeNode search(TreeNode root, int key){

        TreeNode cur = root;
        while ( cur != null ){

            // go to right
            if (key > cur.key) {
                cur = cur.right;
            } else if (key < cur.key){
                cur = cur.left;
            } else {
                return cur;
            }
        }

        return null;
    }
}
