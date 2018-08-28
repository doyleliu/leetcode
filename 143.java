import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> listStack = new Stack<ListNode>();
        ListNode point = head;
        while(point != null){
            listStack.push(point);
            point = point.next;
        }

        while(head != null){
            // if(listStack.size() == 0) break;
            ListNode tmp = listStack.pop();
            if(tmp == head || tmp == head.next){
                tmp.next = null;
                break;
            } 
            // if(tmp == head) tmp.next = null;
            // else if(tmp == head.next) tmp.next = null;
            tmp.next = head.next;
            ListNode prev = head;
            head = head.next;
            prev.next = tmp;
            
        }

        
    }
}