import java.util.*;

class Solution {

    private int findlen(int num) {
        int len = 0;

        while (num > 0) {
            len++;
            num /= 10;
        }

        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        int n = arr1.length;

        HashSet<Integer> set = new HashSet<>();

        // Store all prefixes of arr1
        for (int i = 0; i < n; i++) {

            int x = arr1[i];

            while (x > 0) {
                set.add(x);
                x /= 10;
            }
        }

        int ans = 0;

        // Check prefixes in arr2
        for (int i : arr2) {

            int x = i;
            int size = findlen(x);

            while (x > 0) {

                if (set.contains(x)) {
                    ans = Math.max(ans, size);
                    break;
                }

                x /= 10;
                size--;
            }
        }

        return ans;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr1 = {10};
        int[] arr2 = {17, 11};

        int result = obj.longestCommonPrefix(arr1, arr2);

        System.out.println("Longest Common Prefix Length: " + result);
    }
}