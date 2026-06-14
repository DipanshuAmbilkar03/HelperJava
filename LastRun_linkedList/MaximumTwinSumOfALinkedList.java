package LastRun_linkedList;

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

public class MaximumTwinSumOfALinkedList {

    public static int pairSum(ListNode head) {
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int[] store = new int[count / 2];
        int idx = 0;

        while (idx != count / 2) {
            store[idx++] = head.val;
            head = head.next;
        }

        curr = head;
        int ans = 0;

        for (int i = count / 2 - 1; i >= 0; i--) {
            ans = Math.max(ans, store[i] + curr.val);
            curr = curr.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example: [5,4,2,1]
        ListNode head = new ListNode(
                5,
                new ListNode(
                        4,
                        new ListNode(
                                2,
                                new ListNode(1)
                        )
                )
        );

        System.out.println("Maximum Twin Sum: " + pairSum(head));
    }
}