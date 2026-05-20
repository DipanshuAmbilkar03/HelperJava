package LastRun7.arrays;

import java.util.*;

class Count_Kth_Roots_in_a_Range {

    // Fast Power Function
    private long power(long a, int k, long limit) {

        long ans = 1;

        for (int i = 0; i < k; i++) {

            ans *= a;

            if (ans > limit) {
                return limit + 1;
            }
        }

        return ans;
    }

    // Binary Search for kth root
    private long find(long n, int k) {

        long low = 0;
        long high = 1000000000;

        long ans = -1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            long val = power(mid, k, n);

            if (val <= n) {

                ans = mid;

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return ans;
    }

    // Digit Sum Reduction
    private int check(int i) {

        int sum = 0;

        while (i > 0) {

            int n = i % 10;

            sum += n;

            i /= 10;
        }

        if (sum >= 10) {
            return check(sum);
        }

        return sum;
    }

    public int countKthRoots(int l, int r, int k) {

        if (k == 1) {
            return r - l + 1;
        }

        int num = 0;

        int count = 0;

        while (true) {

            long p = 1;

            for (int i = 0; i < k; i++) {

                p *= num;

                if (p > r) {
                    break;
                }
            }

            if (p > r) {
                break;
            }

            if (p >= l) {
                count++;
            }

            num++;
        }

        return count;
    }

    public static void main(String[] args) {

        Count_Kth_Roots_in_a_Range obj =
                new Count_Kth_Roots_in_a_Range();

        int l = 1;
        int r = 100;
        int k = 2;

        int result = obj.countKthRoots(l, r, k);

        System.out.println("Count of Perfect " + k +
                "th Roots in Range: " + result);
    }
}