import java.util.*;

public class hashimplementation {
    static class HashMap<K,V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private LinkedList<Node> bucket[];
        private int N;

        @SuppressWarnings("unchecked")
        public HashMap() {
            int N = 4;
            this.bucket = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        } 

        private int hashFunction(K key){
            int hc = key.hashCode();
            return (Math.abs(hc) % N);
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldLL[] = bucket;
            bucket = new LinkedList[2*N];
            N = 2*N;
            for(int i=0; i<bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }

            for(int i=0; i<oldLL.length; i++) {
                LinkedList<Node> ll = oldLL[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key,V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
        
            if(di != 0) {
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                bucket[bi].add(new Node(key,value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0) {
                rehash();
            }  
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
        
            if(di != 0) { // valid di
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
        
            if(di != 0) {
                Node node = bucket[bi].remove(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
        
            if(di != 0) {
                Node node = bucket[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 1000);
        hm.put("US", 10);
        hm.put("Nepal", 1); 
        
        ArrayList<String> keys = hm.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
    }
}
