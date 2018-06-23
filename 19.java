/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmphead = head;
        int cnt = 0;
        while(tmphead.next != null){
            tmphead = tmphead.next;
            cnt ++;
        }
        cnt = cnt + 1;
        tmphead = head;
        int i = cnt - n - 1;
        if(i == -1){
            head = head.next;
            return head;
        }
        while(i > 0){
            tmphead = tmphead.next;
            if(tmphead == null){
                return null;
            }
            i --;
        }
        if( tmphead.next == null){
            return head;
        }
        ListNode tmpprev = tmphead.next.next;
        tmphead.next = tmpprev;
        return head;

    }
}