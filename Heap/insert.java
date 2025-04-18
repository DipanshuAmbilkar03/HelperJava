package Heap;

import java.util.ArrayList;

public class insert {
    class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 2;
            int parent = (x - 1) / 2;

            while(arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);   
            }
        }

        public int peek() {
            return arr.get(0);
        }
    }
    public static void main(String[] args) {
        
    }
}
