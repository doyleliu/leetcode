import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stackList = new Stack<TreeNode>();
        if(root == null) return result;
        stackList.add(root);

        while(stackList.size() > 0){
            TreeNode tmp = stackList.pop();
            if(tmp.left != null) stackList.push(tmp.left);
            if(tmp.right != null) stackList.push(tmp.right);
            
            result.add(0, tmp.val);
        }

        return result;
    }
}