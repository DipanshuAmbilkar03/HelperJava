class ListNode {
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

class Solution {
    private ListNode sol1(ListNode head) {
        ListNode h = head;
        int len = 0;

        while (h != null) {
            len++;
            h = h.next;
        }

        int idx = 0;
        ListNode curr = head;

        if (len == 1) return null;

        while (idx != len / 2 - 1) {
            idx++;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }

    private ListNode sol2(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode start = head;
        ListNode end = head;
        ListNode prev = null;

        while (end != null && end.next != null) {
            prev = start;
            end = end.next.next;
            start = start.next;
        }

        prev.next = start.next;

        return head;
    }

    public ListNode deleteMiddle(ListNode head) {
        // return sol1(head);
        return sol2(head);
    }
}

public class DeleteMiddleOfLinkedList {

    static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
            {1},
            {1, 2},
            {1, 2, 3},
            {1, 2, 3, 4},
            {1, 3, 4, 7, 1, 2, 6}
        };

        for (int i = 0; i < testCases.length; i++) {
            ListNode head = createList(testCases[i]);

            System.out.print("Original: ");
            printList(head);

            head = sol.deleteMiddle(head);

            System.out.print("Result:   ");
            printList(head);

            System.out.println();
        }
    }
}