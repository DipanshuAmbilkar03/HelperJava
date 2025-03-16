package findNextGreatestNum;
import java.util.ArrayList;

public class nextGreatestNum {
    public static void main(String[] args) {
        int[] nums = {6,8,0,1,3};
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    list.add(nums[j]);
                    i++;
                }
            }
            list.add(-1);
        }

        System.out.println(list);
    }
}
