package greedy.morganStan_MIcrosoft;
import java.util.*;

public class activitySelection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //total work done in entire process
        int max_count = 0;


        ArrayList<Integer> arr = new ArrayList<>();

        max_count = 1;
        arr.add(0);

        int lastEl = end[0];

        for(int i=1; i<start.length; i++) {
            if(start[i] >= lastEl) {
                max_count++;
                arr.add(i);
                lastEl = end[i];
            }
        }

        System.out.println("Total no of work done in the process are : " + max_count);

        for(int i=0; i<arr.size(); i++) {
            System.out.print("A"+arr.get(i)+" ");
        }

    }
}
