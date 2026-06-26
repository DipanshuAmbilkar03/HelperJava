package LastRun7.CountSubarraysWithMajorityElement;

public class CountSubarraysWithMajorityElementBruteForce {

    public static int countMajoritySubarrays(int[] nums, int target) {

        int answer = 0;
        int n = nums.length;

        for (int start = 0; start < n; start++) {

            int count = 0;

            for (int end = start; end < n; end++) {

                if (nums[end] == target) {
                    count++;
                }

                if (count > (end - start + 1) / 2) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 2, 3, 3};
        int target1 = 3;

        int[] nums2 = {2, 1, 2, 1};
        int target2 = 2;

        int[] nums3 = {5, 5, 5};
        int target3 = 5;

        System.out.println(countMajoritySubarrays(nums1, target1));
        System.out.println(countMajoritySubarrays(nums2, target2));
        System.out.println(countMajoritySubarrays(nums3, target3));
    }
}