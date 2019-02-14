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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode> targethistory = new ArrayList<TreeNode>();
        findtarget(root, target, targethistory);
        int num = 0;
        for(int i = 0; i < targethistory.size(); i ++){
            if(targethistory.get(i) == target){
                num = i;
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        addtarget(targethistory.get(targethistory.size() - 1), K , target, result);
        for(int j = targethistory.size() - 2; j >= 0 ; j --){
            if(targethistory.get(j).left != targethistory.get(j+1)){
                addtarget(targethistory.get(j).left, K - (targethistory.size()  -j) , target, result);
            }
            if(targethistory.get(j).right != targethistory.get(j+1)){
                addtarget(targethistory.get(j).right, K - (targethistory.size() -j) , target, result);
            }
            if(K == (targethistory.size() -j - 1)) result.add(targethistory.get(j).val);
        }
        
        return result;

    }

    boolean findtarget(TreeNode root,  TreeNode target, List<TreeNode> targethistory ){
        if(root == null) return false;
        else if(root.val == target.val){
            targethistory.add(root);
            return true;
        }
        else{
            targethistory.add(root);
            if(findtarget(root.left, target, targethistory)){
                return true;
            }
            else if(findtarget(root.right, target, targethistory)){
                return true;
            }
            else{
                targethistory.remove(targethistory.size() - 1);
                return false;
            }
        }
    }

    void addtarget(TreeNode root, int num, TreeNode target,List<Integer> result){
        if(root == null || num < 0) return;
        if(num == 0){
            result.add(root.val);
        }
        else{
            addtarget(root.left, num -1, target, result);
            addtarget(root.right, num - 1, target, result);
        }
        return;
    }
}