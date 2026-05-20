import java.util.*;

class JumpGame4 {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        HashMap<Integer, List<Integer>> num = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        // Store indices having same values
        for (int i = 0; i < n; i++) {

            if (!num.containsKey(arr[i])) {
                num.put(arr[i], new ArrayList<>());
            }

            num.get(arr[i]).add(i);
        }

        boolean[] vis = new boolean[n];

        int step = 0;

        q.offer(0);

        vis[0] = true;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int cur = q.poll();

                // Reached last index
                if (cur == n - 1) {
                    return step;
                }

                // Move Right
                if (cur + 1 < n && !vis[cur + 1]) {

                    vis[cur + 1] = true;

                    q.offer(cur + 1);
                }

                // Move Left
                if (cur - 1 >= 0 && !vis[cur - 1]) {

                    vis[cur - 1] = true;

                    q.offer(cur - 1);
                }

                // Same Value Jumps
                if (num.containsKey(arr[cur])) {

                    for (int idx : num.get(arr[cur])) {

                        if (!vis[idx]) {

                            vis[idx] = true;

                            q.offer(idx);
                        }
                    }

                    // Remove to avoid repeated processing
                    num.remove(arr[cur]);
                }
            }

            step++;
        }

        return -1;
    }

    public static void main(String[] args) {

        JumpGame4 obj = new JumpGame4();

        int[] arr = {100, 23, 23, 23, 100, 23, 100, 100, 23};

        int result = obj.minJumps(arr);

        System.out.println("Minimum Jumps Required: " + result);
    }
}