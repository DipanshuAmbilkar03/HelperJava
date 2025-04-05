package greedy;

import java.util.Arrays;
import java.util.Collections;

public class chocolaProblem {
    public static void main(String[] args) {
        Integer vertCost[] = {2,1,3,1,4};
        Integer horizCost[] = {4,1,2};        
    
        Arrays.sort(vertCost, Collections.reverseOrder());   
        Arrays.sort(horizCost, Collections.reverseOrder());     
    
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while(h < horizCost.length && v < vertCost.length) {
            // horizontal cut 
            if(vertCost[v] <= horizCost[h]) {
                cost += ( horizCost[h] * vp );
                hp++;
                h++;
            } else { // vertical cut
                cost += ( vertCost[v] * hp );
                vp++;
                v++;
            }
        }

        while(h < horizCost.length) {
            cost += ( horizCost[h] * vp );                
            hp++;
            h++;
        }

        while(v < vertCost.length) {
            cost += ( vertCost[v] * hp );
            vp++;
            v++;
        }

        System.out.println("Total cost to get single chocolate pieces are :" + cost);
    }
}
