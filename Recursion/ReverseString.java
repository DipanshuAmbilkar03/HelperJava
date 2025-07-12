package Recursion;

public class ReverseString {
    public static void reverseString(String str,int idx) {
        if(idx == 0) {
            System.out.print(str.charAt(idx) + ",");
            return;
        }

        System.out.print(str.charAt(idx) + ",");
        reverseString(str, idx-1);
    }
    public static void main(String[] args) {
        String str = "RACECAR";
        int index = str.length()-1;

        reverseString( str, index );
    }
}
