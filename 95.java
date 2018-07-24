import java.util.ArrayList;
import java.util.Enumeration;
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
    public static TreeNode copyTree(TreeNode head){
        if(head == null) return null;
        TreeNode copy = new TreeNode(head.val);
        copy.left = copyTree(head.left);
        copy.right = copyTree(head.right);
        return copy;
    }

    public static void makeTree(List<TreeNode> result , List<Integer> num, TreeNode init ,TreeNode head){
        if(num.size() == 1){
            int value = head.val;
            int tmp = num.get(0);
            if(tmp < value){
                TreeNode left = new TreeNode(tmp);
                head.left = left;
                result.add(copyTree(init));
                head.left = null;
            }
            else{
                TreeNode right = new TreeNode(tmp);
                head.right = right;
                result.add(copyTree(init));
                head.right = null;
            }
        }
        else if(num.size() == 0){
            result.add(copyTree(init));
        }
        else{
            // head = new TreeNode(value);
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();
            for(int i = 0; i < num.size(); i ++){
                if(num.get(i) < head.val){
                    left.add(num.get(i));
                }
                else
                {
                    right.add(num.get(i));
                }
            }

            if(left.size() <= 0){
                head.left = null;
                for(int j = 0; j < right.size(); j ++){
                    int rightnum = right.get(j);
                    right.remove(j);
                    TreeNode tmphead2 = new TreeNode(rightnum);
                    head.right = tmphead2;
                    makeTree(result, right, init,tmphead2);
                    head.right = null;
                    right.add(j,rightnum);
                }
            }
            else if(right.size() <= 0)
            {
                head.right = null;
                for(int i = 0;i < left.size(); i ++){
                    int leftnum = left.get(i);
                    left.remove(i);
                    TreeNode tmphead = new TreeNode(leftnum);
                    head.left = tmphead;
                    makeTree(result, left, init , tmphead);
                    head.left = null;
                    left.add(i,leftnum);
                }
            }
            else{
                for(int i = 0;i < left.size(); i ++){
                    int leftnum = left.get(i);
                    left.remove(i);
                    TreeNode tmphead = new TreeNode(leftnum);
                    head.left = tmphead;
                    makeTree(result, left, init , tmphead);
                    for(int j = 0; j < right.size(); j ++){
                        int rightnum = right.get(j);
                        right.remove(j);
                        TreeNode tmphead2 = new TreeNode(rightnum);
                        head.right = tmphead2;
                        makeTree(result, right, init,tmphead2);
                        head.right = null;
                        right.add(j,rightnum);
                    }
                    head.left = null;
                    left.add(i,leftnum);
                }
            }
            
            
            
        }

    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(n == 0) return result;
        // List<Integer> num = new ArrayList<Integer>();
        // for(int i = 1; i <= n ; i ++){
        //     num.add(i);
        // }
        
        // for(int i = 0; i < n; i ++){
        //     int tmp = num.get(i);
        //     num.remove(i);
        //     TreeNode head = new TreeNode(tmp);
        //     makeTree(result, num, head,head);
        //     num.add(i,tmp);
        // }
        // return result;
        return genTrees(1,n);
    }
    public List<TreeNode> genTrees (int start, int end)
    {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }
        
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        
        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {
            
            left = genTrees(start, i-1);
            right = genTrees(i+1,end);
            
            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
                
        }
        
        return list;
    }
}