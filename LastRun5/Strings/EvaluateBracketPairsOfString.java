import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateBracketPairsOfString {

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> values = new HashMap<>();
        for (List<String> str : knowledge) {
            values.put(str.get(0), str.get(1));
        }

        Boolean startAddKey = false;
        StringBuilder ans = new StringBuilder();
        StringBuilder qusStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                startAddKey = true;
            } else if (ch == ')') {

                // System.out.print(values);
                if (values.containsKey(qusStr.toString())) {
                    // qusStr = new StringBuilder("");
                    ans.append(values.get(qusStr.toString()));
                } else {
                    ans.append('?');
                }
                startAddKey = false;
                qusStr.setLength(0);

            } else if (startAddKey) {
                qusStr.append(ch);
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

    private static List<List<String>> buildKnowledge(String[][] arr) {
        List<List<String>> knowledge = new ArrayList<>();
        for (String[] pair : arr) {
            knowledge.add(Arrays.asList(pair[0], pair[1]));
        }
        return knowledge;
    }

    public static void main(String[] args) {
        String s1 = "(name)is(age)yearsold";
        String[][] k1 = { { "name", "bob" }, { "age", "two" } };
        System.out.println(evaluate(s1, buildKnowledge(k1)));

        String s2 = "hi(name)";
        String[][] k2 = { { "a", "b" } };
        System.out.println(evaluate(s2, buildKnowledge(k2)));

        String s3 = "(a)(a)(a)aaa";
        String[][] k3 = { { "a", "yes" } };
        System.out.println(evaluate(s3, buildKnowledge(k3)));

        String s4 = "hello";
        String[][] k4 = {};
        System.out.println(evaluate(s4, buildKnowledge(k4)));

        String s5 = "(unknown)test(known)";
        String[][] k5 = { { "known", "value" } };
        System.out.println(evaluate(s5, buildKnowledge(k5)));
    }
}
