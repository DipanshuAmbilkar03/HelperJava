import java.util.*;

public class MaximumTotalSubarrayValueII {

    static class SegmentTree {
        int n;
        int[] minValues;
        int[] maxValues;

        SegmentTree(int n) {
            this.n = n;
            minValues = new int[4 * n];
            maxValues = new int[4 * n];
        }

        void insert(int idx, int val) {
            insert(1, 0, n - 1, idx, val);
        }

        void insert(int node, int low, int high, int idx, int val) {
            if (low == high) {
                minValues[node] = val;
                maxValues[node] = val;
                return;
            }

            int mid = low + (high - low) / 2;

            if (idx <= mid) {
                insert(2 * node, low, mid, idx, val);
            } else {
                insert(2 * node + 1, mid + 1, high, idx, val);
            }

            minValues[node] = Math.min(minValues[node * 2], minValues[node * 2 + 1]);
            maxValues[node] = Math.max(maxValues[node * 2], maxValues[node * 2 + 1]);
        }

        int[] query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        int[] query(int node, int lo, int hi, int l, int r) {
            if (r < lo || l > hi) {
                return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            }

            if (l <= lo && hi <= r) {
                return new int[]{minValues[node], maxValues[node]};
            }

            int mid = lo + (hi - lo) / 2;

            int[] left = query(2 * node, lo, mid, l, r);
            int[] right = query(2 * node + 1, mid + 1, hi, l, r);

            return new int[]{
                Math.min(left[0], right[0]),
                Math.max(left[1], right[1])
            };
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < n; i++) {
            tree.insert(i, nums[i]);
        }

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        int[] val = tree.query(0, n - 1);
        pq.offer(new long[]{val[1] - val[0], 0, n - 1});

        Set<String> visited = new HashSet<>();
        visited.add("0#" + (n - 1));

        long ans = 0;

        while (k > 0 && !pq.isEmpty()) {
            long[] curr = pq.poll();

            ans += curr[0];
            k--;

            int l = (int) curr[1];
            int r = (int) curr[2];

            if (l + 1 <= r && !visited.contains((l + 1) + "#" + r)) {
                int[] leftVal = tree.query(l + 1, r);

                visited.add((l + 1) + "#" + r);
                pq.offer(new long[]{
                        leftVal[1] - leftVal[0],
                        l + 1,
                        r
                });
            }

            if (l <= r - 1 && !visited.contains(l + "#" + (r - 1))) {
                int[] rightVal = tree.query(l, r - 1);

                visited.add(l + "#" + (r - 1));
                pq.offer(new long[]{
                        rightVal[1] - rightVal[0],
                        l,
                        r - 1
                });
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumTotalSubarrayValueII sol = new MaximumTotalSubarrayValueII();

        int[] nums = {1, 3, 2, 5};
        int k = 3;

        long result = sol.maxTotalValue(nums, k);

        System.out.println("Answer: " + result);
    }
}