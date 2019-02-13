public class Solution {
    class Result {
        int sum;
        int size;
           TreeNode root;
           Result(TreeNode root, int sum, int size) {
               this.root = root;
               this.sum = sum;
               this.size = size;
           }
       }
   
       private Result subtree = null;
   
       public TreeNode findSubtree2(TreeNode root) {
           if (root == null) return null;
           Result  = getMaxAverage(root);
           return subtree.root;
       }
       private Result getMaxAverage(TreeNode root) {
           if (root.left == null && root.right == null) {
               Result ret = new Result(root, root.val, 1);
               if (subtree == null || subtree.sum < root.val * subtree.size) {
                   subtree = ret;
               }
               return ret;
           }
           Result left = root.left == null ? null: getMaxAverage(root.left);
           Result right = root.right == null ? null: getMaxAverage(root.right);
           Result current = new Result(root, root.val + left == null? 0: left.sum + right == null? 0: right.sum, 1 + left == null? 0: left.size + right == null? 0: right.size);
           if (subtree == null || current.sum * subtree.size > subtree.sum * current.size) {
               subtree = current;
           }
          return current;
       }
   