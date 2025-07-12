package Recursion;

import java.util.*;

public class keyPadCombinations {
    public static String [] keypad = {"._@","abc","def"
                                    ,"ghi","jkl","mno"
                                    ,"pqrs","tuv","wxyz"
                                                        };

    public static void keypadCombinations(String str, int idx, String combination) {
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }

        // 100
        String key;
        char currChar = str.charAt(idx);

        key = keypad[currChar - '1'];
        
        for(int i=0; i<key.length(); i++) {
            keypadCombinations(str, idx+1, combination+key.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print ("enter the number ");
        String str = sc.next();
        System.out.println("The combination are : ");
        keypadCombinations(str, 0, "");
    }
}
