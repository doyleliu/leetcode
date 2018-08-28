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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stackList = new Stack<TreeNode>();

        stackList.push(root);
        if(root == null) return result;

        while(stackList.size() > 0){
            TreeNode tmp = stackList.pop();
            result.add(tmp.val);
            if(tmp.right != null) stackList.push(tmp.right);
            if(tmp.left != null) stackList.push(tmp.left);
            
        }
        return result;

        
    }
}