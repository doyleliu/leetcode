/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode insert = result;
        ListNode insertend = head;
        while(head != null){
            if(head.val >= x){
                break;
            }
            else{
                insert = head;
                head = head.next;
                insertend = head;
            }
        }
        ListNode prev = head;
        while(head != null){
            if(head.val < x){
                ListNode tmp = head;
                head = head.next;
                prev.next = head;
                insert.next = tmp;
                tmp.next = insertend;
                insert = tmp;
            }
            else{
                prev = head;
                head = head.next;
            }

        }
        return result.next;
    }
}