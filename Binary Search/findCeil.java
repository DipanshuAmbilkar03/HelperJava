// User function Template for Java
class Solution {
    public int findCeil(int[] nums, int target) {
        // code here
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return ans;
    }
}
