import java.util.*;

public class Evaluate_Reverse_Polish_Notation_optimized {

    int idx;

    public int evalRPN(String[] tokens) {
        idx = tokens.length - 1;
        return solve(tokens);
    }

    private int solve(String[] tokens) {

        String token = tokens[idx--];

        switch (token) {

            case "+":
                return solve(tokens) + solve(tokens);

            case "-":
                int sub1 = solve(tokens);
                int sub2 = solve(tokens);
                return sub2 - sub1;

            case "*":
                return solve(tokens) * solve(tokens);

            case "/":
                int d1 = solve(tokens);
                int d2 = solve(tokens);
                return d2 / d1;
        }

        return Integer.parseInt(token);
    }

    public static void main(String[] args) {

        EvaluateReversePolishNotation obj =
                new EvaluateReversePolishNotation();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(obj.evalRPN(tokens1));
        // Output: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(obj.evalRPN(tokens2));
        // Output: 6

        String[] tokens3 = {
                "10", "6", "9", "3", "+", "-11",
                "*", "/", "*", "17", "+", "5", "+"
        };

        System.out.println(obj.evalRPN(tokens3));
        // Output: 22
    }
}