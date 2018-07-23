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
        ListNode prev = head;
        ListNode tmp = head;
        ListNode linkprev = head;
        if(head == null || head.next == null) return head;

        tmp = tmp.next;
        while(tmp!=null && tmp.val == prev.val){
            while(tmp != null && tmp.val == prev.val){
                tmp = tmp.next;
            }
            prev = tmp;
            head = tmp;
            if(tmp == null) break;
            tmp = tmp.next;
        }
        if(head == null || head.next == null) return head;
        int count = 0;
        tmp = tmp;
        prev = prev;
        linkprev = prev;
        while(tmp != null){
            // if(count < 2 || tmp.val != prev.val){
            //     prev.next = tmp;
            //     prev = prev.next;
            // }
            // else{
            //     count ++;
            // }
            // tmp = tmp.next;
            if(prev.val == tmp.val){
                count ++;
            }
            else{
                if(count < 2){
                    linkprev.next = prev;
                    linkprev = linkprev.next;
                    prev = tmp;
                    count = 1;
                }
                else{
                    prev = tmp;
                    count = 1;
                }
            }
            tmp = tmp.next;
        }
        if(count < 2){
            linkprev.next = prev;
            linkprev = linkprev.next;
        }
        linkprev.next = null;

        return head;
    }
}