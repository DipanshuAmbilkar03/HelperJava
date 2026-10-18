public class MinDeletionsAdjacentXorNonZero {
    public static int minDeletions(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            int xor = nums[i] ^ nums[i+1]; 
            if(xor != 0) {
                // count++;
                continue;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Test case 1: [1,2,1,2,1] -> 1 (remove one of the middle)
        int[] nums1 = {1,2,1,2,1};
        System.out.println("Test 1: " + minDeletions(nums1));

        // Test case 2: [1,2,3,4,5] -> 0 (all adjacent pairs XOR != 0)
        int[] nums2 = {1,2,3,4,5};
        System.out.println("Test 2: " + minDeletions(nums2));

        // Test case 3: [1,1,1,1] -> 3 (remove three of the four)
        int[] nums3 = {1,1,1,1};
        System.out.println("Test 3: " + minDeletions(nums3));

        // Test case 4: single element -> 0
        int[] nums4 = {42};
        System.out.println("Test 4: " + minDeletions(nums4));

        // Test case 5: [5,5,6,6] -> 2
        int[] nums5 = {5,5,6,6};
        System.out.println("Test 5: " + minDeletions(nums5));
    }
}
