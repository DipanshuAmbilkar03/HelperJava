import java.util.HashSet;
import java.util.Set;

public class UniqueXorTriplets {

    public static int uniqueXorTriplets(int[] nums) {
        // return bruteForce(nums);
        return optimalSolution(nums);
    }

    private static int optimalSolution(int[] nums) {

        int n = nums.length;

        if (n == 1) return 1;
        if (n == 2) return 2;

        int bits = 32 - Integer.numberOfLeadingZeros(n);

        return 1 << bits;
    }

    private static int bruteForce(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {

                    int xor = nums[i] ^ nums[j] ^ nums[k];
                    set.add(xor);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {1, 2};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {1, 2, 3, 4};
        int[] nums5 = {1, 2, 3, 4, 5};

        System.out.println(uniqueXorTriplets(nums1));
        System.out.println(uniqueXorTriplets(nums2));
        System.out.println(uniqueXorTriplets(nums3));
        System.out.println(uniqueXorTriplets(nums4));
        System.out.println(uniqueXorTriplets(nums5));
    }
}