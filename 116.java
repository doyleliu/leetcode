import java.util.ArrayList;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void addconnect(TreeLinkNode root,List<TreeLinkNode> result ,int level){
        if(root == null) return;
        else{
            if(result.size() > level){
                TreeLinkNode tmp = result.get(level);
                tmp.next = root;
                root.next = null;
                result.remove(level);
                result.add(level, root);
                addconnect(root.left, result, level+1);
                addconnect(root.right, result, level+1);
            }
            else{
                root.next = null;
                result.add(level, root);
                addconnect(root.left, result, level+1);
                addconnect(root.right, result, level+1);
            }
        }
    }

    public void connect(TreeLinkNode root) {
        int level = 0;
        List<TreeLinkNode> result = new ArrayList<TreeLinkNode>();
        if(root == null) return;
        else{
            addconnect(root,result, level);
        }
        
    }
}