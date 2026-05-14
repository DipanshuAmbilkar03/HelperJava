package LastRun9_Hashing;

import java.util.*;

public class TopKFrequentElements {

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();

            // Count frequency
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            // Store unique elements
            List<Integer> list = new ArrayList<>(map.keySet());

            // Sort based on frequency in descending order
            Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

            // Store top k elements
            int[] res = new int[k];

            for (int i = 0; i < k; i++) {
                res[i] = list.get(i);
            }

            return res;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans = sol.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements:");

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}