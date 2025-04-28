package Heap;
import java.util.*;

public class connectNRopesWithMinCost {
    public static void main(String[] args) {
        int ropes[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int m1 = pq.remove();
            int m2 = pq.remove();
            cost += m1 + m2;
            pq.add(m1+m2);
        }

        System.out.println("Cost of the entire Connection rope is : " + cost);
    }
}
