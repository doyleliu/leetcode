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
    public static void findPath(TreeNode root, int sum, List<List<Integer>> result, List<Integer> prev) {
        if(root == null){
            return;
        }
        else if(root.left == null && root.right == null){
            if(root.val == sum){
                prev.add(root.val);
                List<Integer> tmp = new ArrayList<Integer>();
                for(int i = 0; i < prev.size(); i ++){
                    tmp.add(prev.get(i));
                }
                result.add(tmp);
                prev.remove(prev.size() - 1);
            }

        }
        else{
            prev.add(root.val);
            findPath(root.left, sum - root.val, result, prev);
            findPath(root.right, sum - root.val, result, prev);
            prev.remove(prev.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> prev = new ArrayList<Integer>();
        if(root == null) return result;
        else{
            findPath(root, sum, result, prev);
            return result;
        }
    }
}