/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        HashMap<Integer,ListNode> map = new HashMap<>();

        ListNode curr = newNode;
        int sum = 0;
        while(curr != null) {
            sum += curr.val;
            map.put(sum,curr);
            curr = curr.next;
        }

        sum = 0;    
        curr = newNode;
        while(curr != null) {
            sum += curr.val;  
            curr.next = map.get(sum).next;
            curr = curr.next;
        }

        return newNode.next;
    }
}