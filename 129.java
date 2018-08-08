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
    public static void add(TreeNode root,List<Integer> result  , int prev){
        if(root == null) return;
        else if(root.left == null && root.right == null){
            int tmp = prev * 10 + root.val + result.get(0);
            result.remove(result.size() - 1);
            result.add(tmp);
        }
        else{
            int tmp = prev * 10 +root.val;
            add(root.left, result, tmp);
            add(root.right, result, tmp);
        }
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if(root == null) return result.get(0);
        else add(root, result, 0);
        return result.get(0);
        
    }
}