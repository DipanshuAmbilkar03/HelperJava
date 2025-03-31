package greedy;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;

public class indianCoin {
    public static void main(String[] args) {
        Integer coins[] = {2000,500,200,100,50,20,10,5,2,1};
        
        Arrays.sort(coins,Comparator.reverseOrder());

        int coincount = 0;
        int amount = 99;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= amount) {
                while (coins[i] <= amount) {
                    coincount++;
                    amount -= coins[i];
                    arr.add(coins[i]);
                }
            }
        }  
        
        System.out.println("coins : " + arr);
        System.out.println("total coins used are : " + coincount);
    }
}
