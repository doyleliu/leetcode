/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode prev = head;
        ListNode prevcut = null;
        ListNode cut = head;
        if(head == null) return null;
        else if(head.next == null){
            TreeNode result = new TreeNode(head.val);
            return result;
        }
        while(head != null){
            head = head.next;
            if(head == null) break;
            head = head.next;
            prevcut = cut;
            cut = cut.next;
        }
        prevcut.next = null;
        TreeNode result = new TreeNode(cut.val);
        result.left = sortedListToBST(prev);
        result.right = sortedListToBST(cut.next);
        return result;

    }
}