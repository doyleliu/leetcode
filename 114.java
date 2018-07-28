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
    public static TreeNode linkflatten(TreeNode root, TreeNode tmp){
        if(root == null) return tmp;
        else{
            TreeNode left = root.left;
            TreeNode right = root.right;
            tmp.right = root;
            tmp.left = null;
            TreeNode last = linkflatten(left, tmp.right);
            last = linkflatten(right, last);
            return last;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null) return ;
        else{
            TreeNode result = root;
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode last = linkflatten(left, result);
            linkflatten(right, last);
            // root = init;
            return;
        }
    }
}