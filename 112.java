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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        else if(root.left == null && root.right == null){
            if(root.val == sum) return true;
            else return false;

        }
        else{
            if(hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) return true;
            else return false;
        }
    }
}