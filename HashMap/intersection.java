import java.util.*;

public class intersection {
    public static int intersection_(int[] arr1, int[] arr2) {
        HashSet<Integer> map = new HashSet<>();
        int count = 0;

        for(int i=0; i<arr1.length; i++) {
            map.add(arr1[i]);
        }

        for(int j=0; j<arr2.length; j++) {
            if(map.contains(arr2[j])) {
                count++;
                map.remove(arr2[j]);
            }
        
        }
        System.out.println("intersection : "+map);
        return count;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,9,8,2,3};
        int[] arr2 = {2,3,4,5};

        System.out.println(intersection_(arr1,arr2));
    }
}
