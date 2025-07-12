import java.util.*;

public class hashImplimentation {
    static class hashImpli<K,V> {
        private class Node {
            K key;
            V val;
            Node(K key, V val) { 
                this.key = key;
                this.val = val;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> bucket[];
        @SuppressWarnings("unchecked")

        public hashImpli() {
            this.N = 4;
            this.bucket = new LinkedList[4];
            
            for(int i=0; i<N; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }  

        private int bucketIndex(K key) {
            int code = key.hashCode();
            return Math.abs(code % N);
        }

        private int dataIndex(K key, int bi) {
            LinkedList<Node> ll = bucket[bi];

            for(int i=0 ; i<ll.size(); i++ ){
                if(ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldLL[] = bucket;
            bucket = new LinkedList[N*2];

            for(int i=0; i<N*2; i++ ){
                bucket[i] = new LinkedList<>();
            }

            for(int i=0; i<oldLL.length; i++) {
                LinkedList<Node> ll = new LinkedList<>();
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.get(i);
                    put(node.key, node.val);
                }
            }
        }
        // put function 
        public void put(K key, V val) {
            int bi = bucketIndex(key);
            int di = dataIndex(key, bi);

            if(di == -1) {
                bucket[bi].add(new Node(key, val));
                n++;
            }else{
                Node node = bucket[bi].get(di);
                node.val = val;
            }

            double lambda = (double)n/N;

            if(lambda > 2.0) {
                rehash();
            }
        }
        // get function 
        public V get(K key) {
            int bi = bucketIndex(key);
            int di = dataIndex(key, bi);

            if(di == -1) {
                return null;
            }else{
                Node node = bucket[bi].get(di);
                return node.val;
            }
        }

        // remove function 
        public void remove(K key) {
            int bi = bucketIndex(key);
            int di = dataIndex(key, bi);

            if(di == -1) {
                System.out.println("nothing present");
            }else{
                Node node = bucket[bi].get(di);
                n--;
                node.val = null;
            }
        }

        // containsKey 
        public boolean containsKey(K key) {
            int bi = bucketIndex(key);
            int di = dataIndex(key, bi);

            if(di == -1) {
                return false;
            }else{
                return true;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);  
                    keys.add(node.key);
                }
            }
            return keys;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        hashImpli<String, Integer> h1 = new hashImpli<>();
    
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1: Put (Insert Key-Value)");
            System.out.println("2: Get (Retrieve Value by Key)");
            System.out.println("3: Remove Key");
            System.out.println("4: Check if Key Exists");
            System.out.println("5: Check if HashMap is Empty");
            System.out.println("6: Display All Keys");
            System.out.println("7: Exit");
            
            int ch = sc.nextInt();
            sc.nextLine(); 
    
            switch (ch) {
                case 1:
                    // Put operation
                    System.out.println("Enter the number of entries:");
                    int entries = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < entries; i++) {
                        System.out.println("Enter key:");
                        String key = sc.nextLine();
                        System.out.println("Enter value:");
                        int value = sc.nextInt();
                        sc.nextLine();
                        h1.put(key, value);
                    }
                    break;
    
                case 2:
                    // Get operation
                    System.out.println("Enter key to retrieve value:");
                    String getKey = sc.nextLine();
                    Integer value = h1.get(getKey);
                    System.out.println(value != null ? "Value: " + value : "Key not found!");
                    break;
    
                case 3:
                    // Remove operation
                    System.out.println("Enter key to remove:");
                    String removeKey = sc.nextLine();
                    h1.remove(removeKey);
                    System.out.println("Key removed if it existed.");
                    break;
    
                case 4:
                    // ContainsKey operation
                    System.out.println("Enter key to check:");
                    String containsKey = sc.nextLine();
                    System.out.println(h1.containsKey(containsKey) ? "Key exists!" : "Key not found!");
                    break;
    
                case 5:
                    // IsEmpty operation
                    System.out.println(h1.isEmpty() ? "HashMap is empty." : "HashMap is not empty.");
                    break;
    
                case 6:
                    // Display all keys
                    System.out.println("Keys and Values:");
                    ArrayList<String> keys = h1.keySet();
                    for (String key : keys) {
                        System.out.println(key + " - " + h1.get(key));
                    }
                    break;
    
                case 7:
                    // Exit case
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
    
                default:
                    System.out.println("Invalid choice, please enter a number between 1-7.");
            }
        }
    }    
}
