package Hashing;

import java.util.HashMap;
import java.util.Set;

public class iterationInHashMap {
    public static void main(String[] args) {
                HashMap<String,Integer> hm = new HashMap<>();

        hm.put("india", 800);
        hm.put("us", 5);
        hm.put("china", 965);
        hm.put("japan", 51);
        hm.put("nepal", 1);


        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k+","+"Value = " +hm.get(k));
        }
    }
}
