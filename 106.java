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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){return null;}
        else if(inorder.length == 1){
            TreeNode result = new TreeNode(inorder[0]);
            return result;
        }
        else{
            TreeNode result = new TreeNode(postorder[postorder.length - 1]);
            int pos = 0;
            for(;pos < inorder.length; pos++){
                if(inorder[pos] == postorder[postorder.length - 1]) break;
            }
            int[] leftinorder = new int[pos];
            int[] leftpostorder = new int[pos];
            int[] rightinorder = new int[inorder.length - 1- pos];
            int[] rightpostorder = new int[inorder.length - 1 -pos];
            for(int i = 0; i < pos ;i ++){
                leftinorder[i] = inorder[i];
                leftpostorder[i] = postorder[i];
            } 
            for(int i = pos+1; i < inorder.length; i++){
                rightinorder[i-pos-1] = inorder[i];
                rightpostorder[i-pos-1] = postorder[i-1];
            }

            result.left = buildTree(leftinorder, leftpostorder);
            result.right = buildTree(rightinorder, rightpostorder);
            return result;


        }
    }
}