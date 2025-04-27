package Heap;

import java.util.ArrayList;

public class insert {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;
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

        private void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minVal = i;

            if(left < arr.size() && arr.get(minVal) > arr.get(left)) {
                minVal = left;
            }

            if(right < arr.size() && arr.get(minVal) > arr.get(right)) {
                minVal = right;
            }

            if(minVal != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minVal));
                arr.set(minVal, temp);

                heapify(minVal);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        } 

        public int remove() {
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1);

            heapify(0);
            return data;
        }
    }   
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3); 
        h.add(4); 
        h.add(1); 
        h.add(5);   

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
