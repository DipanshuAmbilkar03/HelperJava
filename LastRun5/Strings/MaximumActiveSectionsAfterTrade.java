public class MaximumActiveSectionsAfterTrade {

    public static int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();

        int activeOnes = 0;
        int maxMergedZeros = 0;

        int i = 0;
        int previousZeroBlock = 0;

        while (i < n) {

            if (s.charAt(i) == '1') {

                activeOnes++;
                i++;

            } else {

                int currentZeroBlock = 0;

                while (i < n && s.charAt(i) == '0') {
                    currentZeroBlock++;
                    i++;
                }

                if (previousZeroBlock > 0) {
                    maxMergedZeros = Math.max(maxMergedZeros,
                            previousZeroBlock + currentZeroBlock);
                }

                previousZeroBlock = currentZeroBlock;
            }
        }

        return activeOnes + maxMergedZeros;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "1",
                "0",
                "101",
                "1001",
                "100001000",
                "1010101",
                "111100001111",
                "010101000100"
        };

        for (String s : testCases) {
            System.out.println("Input : " + s);
            System.out.println("Output: " + maxActiveSectionsAfterTrade(s));
            System.out.println();
        }
    }
}