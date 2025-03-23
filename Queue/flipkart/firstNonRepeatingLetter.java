package Queue.flipkart;

import java.util.*;

public class firstNonRepeatingLetter {
    public static void repeatedLetter(String letter) {    
        int[] count = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<letter.length(); i++) {
            char ch = letter.charAt(i);

            q.add(ch);
            count[ch - 'a']++;

            while(!q.isEmpty() && count[q.peek()-'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1+" ");
            }else {
                System.out.print(q.peek()+" ");
            }
        }
    }   
    public static void main(String[] args) {
        String str = "aabccxb";
        repeatedLetter(str);
    }
}
