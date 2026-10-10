import java.util.Arrays;

public class MinSumSquareDiff {
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] maxi = new int[n];

        long k = (long) k1 + k2;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            maxi[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiff += maxi[i];
        }

        if (k >= totalDiff) {
            return 0L;
        }

        Arrays.sort(maxi);

        int i = n - 1;

        while (i > 0 && k > 0) {
            long cost = (long) (maxi[i] - maxi[i - 1]) * (n - i);

            if (cost <= k) {
                k -= cost;
                i--;
            } else {
                long reduction = k / (n - i);
                int remainder = (int) (k % (n - i));
                long level = maxi[i] - reduction;

                long ans = 0;

                for (int j = 0; j < i; j++) {
                    ans += (long) maxi[j] * maxi[j];
                }

                ans += (long) (n - i - remainder) * level * level;
                ans += (long) remainder * (level - 1) * (level - 1);

                return ans;
            }
        }

        if (k > 0) {
            long reduction = k / n;
            int remainder = (int) (k % n);
            long level = maxi[0] - reduction;

            return (long) (n - remainder) * level * level + (long) remainder * (level - 1) * (level - 1);
        }

        long ans = 0;

        for (int j = 0; j < i; j++) {
            ans += (long) maxi[j] * maxi[j];
        }

        ans += (long) (n - i) * maxi[i] * maxi[i];

        return ans;

        
        // int[] maxi = new int[nums1.length];
        // int n = nums1.length;

        // if(k1==0 && k2 == 0) 
        //     int ans = 0;    
        //     for(int i=0; i<n; i++) 
        //         ans += (Math.abs(nums1[i]-nums2[i])*Math.abs(nums1[i]-nums2[i]));
        
        //     return ans;

        // for(int i=0; i<n; i++) {
        //     maxi[i] = check(nums1[i],nums2[i],k1,k2);
        // }

        // Arrays.sort(maxi);
        
        // int ans = 0;
        // for(int i=0; i<n; i++) 
        //     ans += (Math.abs(nums1[i]-nums2[i])*Math.abs(nums1[i]-nums2[i]));


        // return ans;
    }

    // private int solve(int[] nums1, int[] nums2,int k1, int k2) {
    //     int sent = 0;

    //     if((k1 == 1 && k2 == 0) && (k1 == 0 && k2 == 1)) {

    //     } else if((k1 >= 2 && k2 == 0) && (k1 == 0 && k2 == 1)) {
            
    //     }
    // }

    public static void main(String[] args) {
        System.out.println(minSumSquareDiff(new int[]{1, 2, 3, 4}, new int[]{2, 10, 20, 19}, 0, 0)); // 579
        System.out.println(minSumSquareDiff(new int[]{1, 4, 10, 12}, new int[]{5, 8, 6, 9}, 1, 1)); // 43
        System.out.println(minSumSquareDiff(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 5, 5)); // 0
        System.out.println(minSumSquareDiff(new int[]{1}, new int[]{10}, 4, 4)); // 1
        System.out.println(minSumSquareDiff(new int[]{4, 3}, new int[]{1, 1}, 1, 1)); // 5
    }
}
