import java.util.*;

public class iternaryFromTickets {
    public static String getStart(HashMap<String,String> tick) {
        HashMap<String,String> newmap = new HashMap<>();

        for(String key : tick.keySet()) {
            newmap.put(tick.get(key), key);
        }

        for(String key : tick.keySet()) {
            if(!newmap.containsKey(key)) {
                return key;
            }
        }
        return null;
    } 
    public static void main(String[] args) {
        HashMap<String,String> tick = new HashMap<>();
        tick.put("chennai","benglore");
        tick.put("mumbai","delhi"); 
        tick.put("goa","chennai");
        tick.put("delhi","goa");

        String start = getStart(tick);

        System.out.println("Starting point : " + start);


        while(tick.containsKey(start)) {
            System.out.print(start+ "->");
            start = tick.get(start);
        }
        System.out.println(start);
    }
}
