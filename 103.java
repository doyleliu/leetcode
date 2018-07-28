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
    public static void addOrder(List<List<Integer>> result,TreeNode root, int level){
        if(root == null) return;
        else{
            if(result.size() > level){
                List<Integer> tmproot = result.get(level);
                if(root != null){
                    if(level % 2== 0){
                        tmproot.add(root.val);
                    }
                    else{
                        tmproot.add(0,root.val);
                    }
                }
                addOrder(result, root.left, level+1);
                addOrder(result, root.right, level+1);
            }
            else{
                List<Integer> tmproot = new ArrayList<Integer>();
                result.add(tmproot);
                if(root != null){
                    if(level % 2== 0){
                        tmproot.add(root.val);
                    }
                    else{
                        tmproot.add(0,root.val);
                    }
                }
                addOrder(result, root.left, level+1);
                addOrder(result, root.right, level+1);
            }     
        }

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        int level = 0;
        List<Integer> tmproot = new ArrayList<Integer>();
        tmproot.add(root.val);
        result.add(tmproot);
        addOrder(result, root.left, level+1);
        addOrder(result, root.right, level+1);
        return result;
    }
}