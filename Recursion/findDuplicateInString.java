package Recursion;

public class findDuplicateInString {
    static int alphabet = 26;
    public static boolean[] map = new boolean[alphabet];

    public static void duplicateCharacter(String str, int idx, String newString, String duplicate, int count){
        if(idx == str.length()) {
            System.out.println("Total duplicate characters are : "+ count +" => " + duplicate);
            System.out.println(newString);

            return;
        }

        char ch = str.charAt(idx);
        if(map[ch - 'a'] == true) {
            duplicate += ch;
            count++;
            duplicateCharacter(str, idx+1, newString,duplicate,count);
        }else{
            newString += ch;
            map[ch - 'a'] = true;
            duplicateCharacter(str, idx+1, newString,duplicate,count);
        }
    }
    public static void main(String[] args) {
        duplicateCharacter("abcabcd", 0, "", "" ,0);
    }
}
