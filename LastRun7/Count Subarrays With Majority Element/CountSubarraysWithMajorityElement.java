public class CountSubarraysWithMajorityElement {

    public static long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;
        int size = 2 * n + 2;

        long[] countSum = new long[size];
        long[] prefixSum = new long[size];

        long answer = 0;

        int index = n + 1;

        countSum[index] = 1;
        prefixSum[index] = 1;

        for (int num : nums) {

            if (num == target) {
                index++;
            } else {
                index--;
            }

            countSum[index]++;

            answer += prefixSum[index - 1];

            prefixSum[index] = prefixSum[index - 1] + countSum[index];
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