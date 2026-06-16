package HackerRank.Strings;

import java.io.*;
import java.util.*;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean ans = true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) { 
                ans = false;
                break;
            }
            left++;right--;
            
        }
        
        System.out.print(ans ? "Yes" : "No");
    }   
}
