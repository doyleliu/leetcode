import javax.swing.ListModel;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmp = head;
        int n = 0;
        if(tmp == null) return head;
        else if(k == 0) return head;
        while(tmp!=null){
            n = n + 1;
            tmp = tmp.next;
        }
        tmp = head;
        ListNode end = new ListNode(0);
        while(k >= n ){k = k -n;}
        if(k == 0) return head;
        if(n-k-2 <0) end = head;
        for(int i = 0; i < n - k ;i ++)
        {
            tmp = tmp.next;
            if(i == n-k-2) end = tmp;
        }
        // ListNode end = tmp;
        // tmp.next = null;
        ListNode result = tmp;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = head;
        end.next =null;
        return result;
    }
}