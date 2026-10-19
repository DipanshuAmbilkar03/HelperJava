import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public static List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;     
        List<Integer> newarr = new ArrayList<>();
        // Arrays.sort(nums);
        // for(int i=0; i<n; i++) {
        //     if(nums[i] == target) newarr.add(i);
        // }

        // return newarr;

        
        List<Integer> res = new ArrayList<>();
        int less = 0, same = 0;
        for(int i: nums) {
            if(i < target) less++;
            else if(i == target) same++;
        }

        // 1 2 2 3 5 
 
        for(int i=less; i<less+same; i++) {
            res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        // Test case 1: nums = [1,2,5,2,3], target = 2 -> [1,2]
        int[] nums1 = {1,2,5,2,3};
        System.out.println("Test 1: " + targetIndices(nums1, 2));

        // Test case 2: nums = [1,2,5,2,3], target = 3 -> [3]
        int[] nums2 = {1,2,5,2,3};
        System.out.println("Test 2: " + targetIndices(nums2, 3));

        // Test case 3: nums = [1,2,5,2,3], target = 5 -> [4]
        int[] nums3 = {1,2,5,2,3};
        System.out.println("Test 3: " + targetIndices(nums3, 5));

        // Test case 4: target not present -> []
        int[] nums4 = {1,2,5,2,3};
        System.out.println("Test 4: " + targetIndices(nums4, 4));

        // Test case 5: all elements equal to target -> [0,1,2]
        int[] nums5 = {7,7,7};
        System.out.println("Test 5: " + targetIndices(nums5, 7));

        // Test case 6: target is the smallest -> [0]
        int[] nums6 = {1,3,5,7};
        System.out.println("Test 6: " + targetIndices(nums6, 1));

        // Test case 7: target is the largest -> [n-1]
        int[] nums7 = {1,3,5,7};
        System.out.println("Test 7: " + targetIndices(nums7, 7));
    }
}
