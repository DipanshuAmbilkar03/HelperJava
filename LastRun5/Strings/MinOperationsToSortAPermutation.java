public class MinOperationsToSortAPermutation {
    public static int minOperations(int[] nums) {
        int x = 0;
        while(nums[x] != 0) {
            x++;
        }
        int n = nums.length;
        boolean inc = true;
        boolean dec = true;

        for(int i=1; i<n; i++) {
            final int num = nums[(i+x)%n];

            if(num != i) inc = false;
            if(num != n-i) dec = false;
            if(!inc && !dec)return -1;    
        }

        if(inc) return Math.min(x,n-x+2);
        return Math.min(n-x,x+2); 
    }

    public static void main(String[] args) {
        // Test case 1: nums = [0,2,1] -> 2 (rotate left once, then reverse)
        int[] nums1 = {0,2,1};
        System.out.println("Test 1: " + minOperations(nums1));

        // Test case 2: nums = [1,0,2] -> 2 (reverse, then rotate left once)
        int[] nums2 = {1,0,2};
        System.out.println("Test 2: " + minOperations(nums2));

        // Test case 3: nums = [2,0,1,3] -> -1 (impossible)
        int[] nums3 = {2,0,1,3};
        System.out.println("Test 3: " + minOperations(nums3));

        // Test case 4: nums = [0,1,2] -> 0 (already sorted)
        int[] nums4 = {0,1,2};
        System.out.println("Test 4: " + minOperations(nums4));

        // Test case 5: nums = [1,2,0] -> 2 (rotate left twice)
        int[] nums5 = {1,2,0};
        System.out.println("Test 5: " + minOperations(nums5));

        // Test case 6: nums = [2,1,0] -> 1 (reverse)
        int[] nums6 = {2,1,0};
        System.out.println("Test 6: " + minOperations(nums6));

        // Test case 7: nums = [3,0,1,2] -> 1 (rotate left once)
        int[] nums7 = {3,0,1,2};
        System.out.println("Test 7: " + minOperations(nums7));

        // Test case 8: nums = [0,3,2,1] -> 2 (reverse, then rotate left once)
        int[] nums8 = {0,3,2,1};
        System.out.println("Test 8: " + minOperations(nums8));

        // Test case 9: nums = [1,0,2,3] -> -1 (impossible)
        int[] nums9 = {1,0,2,3};
        System.out.println("Test 9: " + minOperations(nums9));
    }
}
