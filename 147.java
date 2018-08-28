/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = head;
        if(result == null || result.next == null) return result;
        ListNode prev = head;
        ListNode tmp = head.next;
        while(tmp != null){
            if(tmp.val < result.val){
                ListNode inner = tmp.next;
                tmp.next = result;
                prev.next = inner;
                result = tmp;
                tmp = prev;
            }
            else if(prev.val > tmp.val){
                ListNode innerprev = result;
                ListNode init = result.next;
                while(init!= null && init.val < tmp.val ){
                    init = init.next;
                    innerprev = innerprev.next;
                }
                ListNode inner = tmp.next;
                tmp.next = init;
                innerprev.next = tmp;
                prev.next = inner;
                tmp = prev;
                
            }
            prev = tmp;
            tmp = tmp.next;
        }
        return result;
    }
}