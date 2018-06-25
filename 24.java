/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null) return head;
        ListNode finalans = new ListNode(0);
        ListNode result = finalans;
        while(head != null && head.next != null){
            ListNode tmpNode = head.next;
            ListNode tmpAfter = tmpNode.next;
            tmpNode.next = head;
            finalans.next = tmpNode;
            head.next = tmpAfter;
            finalans = head;
            head = tmpAfter;
        }
        return result.next;
        
    }
}