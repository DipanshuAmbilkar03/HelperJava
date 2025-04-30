package Heap;
import java.util.*;

public class slidingWindow {
    static class Pair implements Comparable<Pair>{
        int win;
        int idx;

        public Pair(int win, int idx) {
            this.win = win;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // ascending order//
            // return this.win - p2.win;

            // descending order
            return p2.win - this.win;

        }
    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i],i));
        }

        res[0] = pq.peek().win;

        for(int i=k; i<arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx < (i-k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().win;
        }

        // result 

        for(int i=0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
