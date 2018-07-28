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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums== null || nums.length == 0) return null;
        if(nums.length == 1){
            TreeNode result = new TreeNode(nums[0]);
            return result;
        }
        else{
            int tmp = nums[nums.length/2];
            TreeNode result = new TreeNode(tmp);
            int[] left = new int[nums.length/2];
            int[] right = new int[nums.length - nums.length/2 - 1];
            for(int i = 0;i < left.length; i ++) left[i] = nums[i];
            for(int i = 0; i < right.length;i ++) right[i] = nums[i + nums.length/2 + 1];
            result.left = sortedArrayToBST(left);
            result.right = sortedArrayToBST(right);
            return result;
        }
    }
}