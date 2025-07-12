package Recursion;

public class moveXtoLast {
    public static void moveX(String str,int count,int idx, String newString) {
        if(idx == str.length()) {
            for(int i=0; i<count ; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        
        if(currChar == 'x' || currChar == 'X') {
            count++;
            moveX(str,count, idx+1, newString);
        }else{
            newString += currChar;
            moveX(str,count, idx+1, newString);
        }
    }
    public static void main(String[] args) {
        String str = "abcXxbxc";
        moveX(str,0, 0, "");
    }
}
