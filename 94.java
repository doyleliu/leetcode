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
    public static void inorderprint(List<Integer> result,TreeNode root){
        if(root == null){
            return;
        }
        else{
            inorderprint(result, root.left);
            result.add(root.val);
            inorderprint(result, root.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderprint(result, root);
        return result;
    }
}