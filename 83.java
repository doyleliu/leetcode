/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ) return head;
        ListNode result = head;
        ListNode prev = head;
        ListNode tmp = head;
        int count = 0;
        while(tmp!=null){
            if(tmp.val == prev.val){
                count ++;
            }
            else{
                prev.next = tmp;
                prev = prev.next;
            }
            tmp = tmp.next;
            prev.next = null;

        }
        return result;
    }
}