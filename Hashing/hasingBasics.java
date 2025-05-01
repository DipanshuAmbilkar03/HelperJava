package Hashing;
import java.util.*;

public class hasingBasics {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("India", 800);
        hm.put("US", 5);
        hm.put("China", 965);

        System.out.println(hm);

        int population = hm.get("US");
        System.out.println(population);

        System.out.println(hm.get("bhutan"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("india"));

        System.out.println(hm.remove("China"));
        System.out.println(hm);
        
        System.out.println(hm.remove("japan"));
        System.out.println(hm);

        // size
        System.out.println("SIZE : "+hm.size());

        // empty 
        System.out.println("Hashmap is empty ? => " + hm.isEmpty());

        // clear
        hm.clear();
        System.out.println(hm);
    }
}
