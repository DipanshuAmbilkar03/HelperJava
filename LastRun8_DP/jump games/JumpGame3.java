import java.util.*;

class JumpGame3 {

    public boolean canReach(int[] arr, int start) {

        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[n];

        q.offer(start);

        vis[start] = true;

        while (!q.isEmpty()) {

            int cur = q.poll();

            if (arr[cur] == 0) {
                return true;
            }

            // Forward Jump
            if (cur + arr[cur] < n && !vis[cur + arr[cur]]) {

                vis[cur + arr[cur]] = true;

                q.offer(cur + arr[cur]);
            }

            // Backward Jump
            if (cur - arr[cur] >= 0 && !vis[cur - arr[cur]]) {

                vis[cur - arr[cur]] = true;

                q.offer(cur - arr[cur]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        JumpGame3 obj = new JumpGame3();

        int[] arr = {4, 2, 3, 0, 3, 1, 2};

        int start = 5;

        boolean result = obj.canReach(arr, start);

        System.out.println("Can Reach Zero: " + result);
    }
}