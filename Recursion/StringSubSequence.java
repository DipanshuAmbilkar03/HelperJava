package Recursion;

public class StringSubSequence {
    static int count = 0;
    static double limit = Math.pow(5, 7);

    public static void StrSubSeq(String str, int idx,String newString) {
        if(count >= limit){
            System.out.println("Max Limit reached." + "i.e "+ limit);
            return;
        }
        if(idx == str.length()) {
            System.out.println(newString);
            count++;
            return;
        }
        
        char currChar = str.charAt(idx);
        StrSubSeq(str, idx+1, newString+currChar);
        StrSubSeq(str, idx+1, newString);
    }
    public static void main(String[] args) {
        String str = "abcd";
        StrSubSeq(str, 0, "");
        System.out.println("Total SubString are : "+count);
    }
}
