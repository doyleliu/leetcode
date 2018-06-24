/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode finalResult = new ListNode(0);
        ListNode result = finalResult;
        // if(l1.val <= l2.val){
        //     result.val = l1.val;
            
        // }
        // else{
        //     result.val = l2.val;
        // }
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        while(l1 != null){
            if(l1.val <= l2.val){
                result.val = l1.val;
                l1 = l1.next;
                result.next = new ListNode(0);
                result = result.next;
            }
            else{
                result.val = l2.val;
                l2 = l2.next;
                result.next = new ListNode(0);
                result = result.next;
                if(l2 == null) break;
            }
        }
        if(l1 == null){
            if(l2 == null) return finalResult;
            else{
                result.val = l2.val;
                result.next = l2.next;
            }
        }
        else{
            if(l1 == null) return finalResult;
            else{
                result.val = l1.val;
                result.next = l1.next;
            }  
        }
        return finalResult;
    }
}