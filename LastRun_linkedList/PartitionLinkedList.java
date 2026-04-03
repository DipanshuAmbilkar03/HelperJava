package LastRun_linkedList;

import java.util.*;

public class PartitionLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);

        ListNode b = before;
        ListNode a = after;

        while (head != null) {
            if (head.val < x) {
                b.next = head;
                b = b.next;
            } else {
                a.next = head;
                a = a.next;
            }
            head = head.next;
        }

        a.next = null;           // Important to avoid cycle
        b.next = after.next;     // Merge two lists

        return before.next;
    }

    // Helper: Create Linked List from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Helper: Print Linked List
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        PartitionLinkedList obj = new PartitionLinkedList();

        int[] arr = {1, 4, 3, 2, 5, 2};
        int x = 3;

        ListNode head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        ListNode result = obj.partition(head, x);

        System.out.print("Partitioned List: ");
        printList(result);
    }
}