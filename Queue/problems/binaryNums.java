package Queue.problems;

import java.util.*;

public class binaryNums {
    public static void binarynum(int num) {
        Stack s = new Stack<>();

        for(int i=1; i<=num; i++) {
            int n = i;
            while (n > 0) {
                s.push(n % 2);
                n = n / 2;
            }
    
            System.out.print(i + "->");
            while(!s.isEmpty()) {
                
                System.out.print(s.peek() + " ");
                s.pop();
            }
            System.out.println();
        }   
    }
    public static void main(String[] args) {
        int opt = 5;
        binarynum(opt);
    }
}
