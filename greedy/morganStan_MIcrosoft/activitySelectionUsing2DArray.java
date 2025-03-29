package greedy.morganStan_MIcrosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activitySelectionUsing2DArray {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        
        int arr2d[][] = new int[start.length][3];
            
        for(int i=0; i<start.length;i++) {
            arr2d[i][0] = i;
            arr2d[i][1] = start[i];
            arr2d[i][2] = end[i];
        }

        Arrays.sort(arr2d,Comparator.comparingDouble(o -> o[2]));

        //total work done in entire process
        int max_count = 0;


        ArrayList<Integer> arr = new ArrayList<>();

        max_count = 1;
        arr.add(arr2d[0][0]);

        int lastEl = arr2d[0][2];

        for(int i=1; i<start.length; i++) {
            if(arr2d[i][1] >= lastEl) {
                max_count++;
                arr.add(arr2d[i][0]);
                lastEl = arr2d[i][2];
            }
        }

        System.out.println("Total no of work done in the process are : " + max_count);

        for(int i=0; i<arr.size(); i++) {
            System.out.print("A"+arr.get(i)+" ");
        }
    }
}
