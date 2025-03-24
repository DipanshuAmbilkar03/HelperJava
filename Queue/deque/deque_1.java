package Queue.deque;

import java.util.*;

public class deque_1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(1);

        System.out.println(deque);

        deque.removeFirst();
        System.out.println(deque);

        deque.removeLast();
        System.out.println(deque);
    }
}
