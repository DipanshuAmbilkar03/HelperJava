import java.util.*;

public class BinaryGap {

    public static int binaryGap(int n) {

        String bin = Integer.toBinaryString(n);

        int last = -1;
        int gap = 0;

        for (int i = 0; i < bin.length(); i++) {

            if (bin.charAt(i) == '1') {

                if (last != -1) {
                    gap = Math.max(gap, i - last);
                }

                last = i;
            }
        }

        return gap;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = binaryGap(n);

        System.out.println("Binary Gap: " + result);

        sc.close();
    }
}