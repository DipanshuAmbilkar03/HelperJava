import java.util.Stack;

public class validparanthsis {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length();i++) {
            char ch = str.charAt(i);
            
            // opening
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {

                // Empty Stack
                if(s.isEmpty()) {
                    return false;
                }

                // Closing 
                if(s.peek() == '(' && ch == ')'
                || s.peek() == '{' && ch == '}'
                || s.peek() == '[' && ch == ']') {
                    return true;
                } else {
                    return false;
                }
            }
        }

        // last check 
        if(s.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        // valid - ({[]}) ()[]{} 
        // invalid - { ( [ ) {} ]}    ( [ } )   

        String str = "{[()]}";
        System.out.println(isValid(str));
    }
}
