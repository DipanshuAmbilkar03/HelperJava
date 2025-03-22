package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class queueJavaCollectionFrameWork {
    public static void main(String[] args) {
        // queue using linkedlist class
        // Queue<Integer> q = new LinkedList<>();

        // queue using arrayDequeue class
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
