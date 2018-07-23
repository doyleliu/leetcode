/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = head;
        ListNode init = new ListNode(0);
        init.next = head;
        result = init;
        ListNode left = init;
        ListNode right = head;
        ListNode prev = head;
        ListNode after = head;
        ListNode tmp = head;
        int num = 0;
        while(head!=null){
            num ++;
            if(num < m)left = head;

            if(num == m){
                prev = head;
                head = head.next;
                prev.next = null;
                after= prev;
                tmp = prev;
            }
            else if(num> m && num <= n){
                prev = head;
                head = head.next;
                prev.next = tmp;
                tmp = prev;
            }
            else{
                head = head.next;
            }

            
            if(num == n) right = head;
            // if(num == m){
                
            // }
            // else if(num == n){

            // }
            // else{
            //     if(num < m)left = head;
            //     head = head.next;
            //     if(num >= n) right = head;
            // }
        }
        left.next = tmp;
        after.next = right;
        result = result.next;
        return result;


    }
}