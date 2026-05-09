package LastRun9_Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // Store all elements in HashSet
        for (int i : nums) {
            set.add(i);
        }

        int len = 0;

        // Traverse through set
        for (int i : set) {

            // Start only if previous element is absent
            if (!set.contains(i - 1)) {

                int curr = i;
                int start = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    start++;
                }

                len = Math.max(len, start);
            }
        }

        return len;
    }

    public static void main(String[] args) {

        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        int[] nums = {100, 4, 200, 1, 3, 2};

        int ans = obj.longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + ans);
    }
}