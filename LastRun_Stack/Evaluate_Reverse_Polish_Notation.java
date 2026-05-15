package LastRun_Stack;

import java.util.*;

public class Evaluate_Reverse_Polish_Notation {

    public static int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        if (op.equals("*")) return a * b;
        return a / b;
    }

    public static int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            switch (token) {

                case "+" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1 + op2);
                }

                case "-" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 - op1);
                }

                case "*" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1 * op2);
                }

                case "/" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 / op1);
                }

                default -> {
                    int num = Integer.parseInt(token);
                    stack.push(num);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};

        int result = evalRPN(tokens);

        System.out.println("Result: " + result);
    }
}