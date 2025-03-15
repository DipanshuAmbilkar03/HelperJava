import java.util.ArrayList;

public class Implementation{  
    static class stack2 {
        static ArrayList<Integer> s = new ArrayList<>(); 
        public static void push_(int data) {
            s.add(data);
        }

        public static boolean isEmpty_() {
            return s.size() == 0;
        }

        public static void pop_() {
            s.remove(s.get(s.size()-1));
        }

        public static int peek_() {
            return s.get(s.size()-1);
        }
    }
    
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>() ;
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek() {
            return list.get(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        stack2 s2 = new stack2();
        s2.push_(1);
        s2.push_(2);
        s2.push_(3);

        while(!s2.isEmpty_()) {
            System.out.println(s2.peek_());
            s2.pop_();
        }
    }
}