import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public static void getMax(TreeNode root, List<Integer> result ,int level){
    //     if(root == null){
    //         result.add(level);
    //     }
    //     else{
    //         getMax(root.left, result, level+1);
    //         getMax(root.right, result, level+1);
    //     }
    // }

    public static int getDepth(TreeNode root){
        if(root == null) return 0;
        else{
            int left = 0;
            int right = 0;
            if(root.left != null) left = 1+getDepth(root.left);
            if(root.right != null) right = 1+getDepth(root.right);
            return Math.max(left, right);
        }
    }

    public static int maxDepth(TreeNode root) {
        int result = 0;
        if(root == null) return result;
        result = 1 + getDepth(root);
        return result;
        
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        else{
            int num = Math.abs(maxDepth(root.left) - maxDepth(root.right));
            if(num <= 1) return(isBalanced(root.left) && isBalanced(root.right));
            else return false;
        }

        // if(root == null) return true;
        // List<Integer> result = new ArrayList<Integer>();
        // int level = 0;
        // getMax(root, result, level);
        // int min = result.get(0);
        // int max = result.get(1);
        // for(int i = 0; i < result.size(); i ++){
        //     int tmp = result.get(i);
        //     if(tmp < min) min = tmp;
        //     if(tmp > max) max = tmp;
        // }

        // if(max -min > 1) return false;
        // else return true;
    }
}