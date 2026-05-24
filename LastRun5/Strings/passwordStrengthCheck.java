package LastRun5.Strings;
import java.util.*;

class passwordStrengthCheck {
    public int passwordStrength(String password) {
        int point = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(set.contains(ch)) {
                continue;
            }
            set.add(ch);
            if (Character.isLowerCase(ch)) {
                point += 1;
            }
            else if (Character.isUpperCase(ch)) {
                point += 2;
            }
            else if (Character.isDigit(ch)) {
                point += 3;
            }
            else if ("!@#$".indexOf(password.charAt(i)) != -1) {
                point += 5;
            }
        }
        return point;
    }
}