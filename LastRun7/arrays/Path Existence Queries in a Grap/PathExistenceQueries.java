import java.util.*;

public class PathExistenceQueries {

    public static int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            map.put(arr[i][1], i);
        }

        int LOG = 1;
        while ((1 << LOG) < n) {
            LOG++;
        }

        int[][] up = new int[n][LOG];

        int right = 0;

        for (int left = 0; left < n; left++) {

            while (right < left) {
                right = left;
            }

            while (right + 1 < n && arr[right + 1][0] - arr[left][0] <= maxDiff) {
                right++;
            }

            up[left][0] = right;
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int start = map.get(queries[i][0]);
            int end = map.get(queries[i][1]);

            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            if (start == end) {
                ans[i] = 0;
                continue;
            }

            int curr = start;
            int jumps = 0;

            for (int j = LOG - 1; j >= 0; j--) {
                if (up[curr][j] < end) {
                    curr = up[curr][j];
                    jumps += (1 << j);
                }
            }

            if (up[curr][0] >= end) {
                ans[i] = jumps + 1;
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int n1 = 5;
        int[] nums1 = {1, 3, 6, 10, 15};
        int maxDiff1 = 4;
        int[][] queries1 = {
                {0, 1},
                {0, 2},
                {1, 4},
                {3, 4},
                {2, 2}
        };

        System.out.println(Arrays.toString(
                pathExistenceQueries(n1, nums1, maxDiff1, queries1)));

        int n2 = 6;
        int[] nums2 = {2, 5, 8, 12, 14, 18};
        int maxDiff2 = 3;
        int[][] queries2 = {
                {0, 5},
                {1, 3},
                {2, 4},
                {4, 5}
        };

        System.out.println(Arrays.toString(
                pathExistenceQueries(n2, nums2, maxDiff2, queries2)));
    }
}