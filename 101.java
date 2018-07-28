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
    public static boolean judgeSymmetric(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;
        else if(left == null && right != null) return false;
        else if(left != null && right == null) return false;
        // else if(left.left == null && right.right != null) return false;
        // else if(left.right == null && right.left != null) return false;
        // else if(left.left != null && right.right == null) return false;
        // else if(left.right != null && right.left == null) return false;
        else{
            if(left.val == right.val){
                return (judgeSymmetric(left.left, right.right) && judgeSymmetric(left.right, right.left));
            }
            else return false;
        }

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else if(root.left == null && root.right != null) return false;
        else if(root.left != null && root.right == null) return false;
        else{
            TreeNode left = root;
            TreeNode right = root;
            return judgeSymmetric(left, right);

        }
          
    }
}