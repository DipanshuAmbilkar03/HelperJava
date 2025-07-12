import java.util.*;

public class majorityElement {
    public static void findMajority(int nums[]) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i] , 1);
            }

            int chall = n/3;

            for(int key : map.keySet()) { 
                if(map.get(key) > chall) {
                    System.out.print(key + ",");
                }
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2};
        findMajority(nums);
    }
}
