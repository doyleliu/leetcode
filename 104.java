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

    public int maxDepth(TreeNode root) {
        int result = 0;
        if(root == null) return result;
        result = 1 + getDepth(root);
        return result;
        
    }
}