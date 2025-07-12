package Recursion;

public class checkDuplicate {
    public static boolean[] map = new boolean[26];

    public static void findDuplicate(String str, int idx,String newString) {
        if(idx == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            findDuplicate(str, idx+1,newString);
        }else{
            newString += currChar;
            map[currChar - 'a'] = true;
            findDuplicate(str, idx+1 ,newString);
        }
    }
    public static void main(String[] args) {
        // abcxxbxc
        String str = "abcxxbxc";
        findDuplicate(str, 0, "");
    }
}
