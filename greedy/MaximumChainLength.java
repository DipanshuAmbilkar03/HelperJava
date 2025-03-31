package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumChainLength {
    public static void main(String[] args) {
        int time[][] = {{5,24},
                        {39,60},
                        {5,28},
                        {27,40},
                        {50,90},};

        Arrays.sort(time,Comparator.comparingDouble(o -> o[1]));

        int chainCount = 1;
        int ChainEnd = time[0][1];

        for(int i=1; i<time.length; i++) {
            if(time[i][0] > ChainEnd) {
                ChainEnd = time[i][1];
                chainCount++;
            }
        }

        System.out.println("Total chain length found in the time stamp is :" + chainCount);
    }
}
