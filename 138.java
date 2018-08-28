import java.util.ArrayList;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode deepcopy(RandomListNode head){
        if(head == null) return null;
        if(map.containsKey(head)){
            return map.get(head);
        }
        
        RandomListNode tmp = new RandomListNode(head.label);
        map.put(head,tmp);

        if(!map.containsKey(head.next)) tmp.next = deepcopy(head.next);
        if(!map.containsKey(head.random)) tmp.random = deepcopy(head.random);
        return tmp;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        // List<RandomListNode> marked = new ArrayList<RandomListNode>();
        // RandomListNode result = deepcopy(head);
        if (head == null) return null;
        // return result;
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
  
        return map.get(head);
    }
}