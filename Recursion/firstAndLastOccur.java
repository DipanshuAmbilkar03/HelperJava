
package Recursion;

public class firstAndLastOccur {
    public static int first = -1;
    public static int last = -1;

    public static void firstLastOccurance(String str,int idx,char el) {
        if(idx == str.length()) {
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar == el) {
            if(first == -1) {
                first = idx;
            }else{
                last = idx;
            }
        }

        firstLastOccurance(str, idx+1, el);
    }
    public static void main(String[] args) {
        String str = "vnasujvb dfszxjawnsodcj ns;zxlcn oslxjnc wo;asjx";
        int index = 0;
        char el = 's';
        System.out.println("Total character in string are : " + str.length());
        firstLastOccurance(str,index , el);
    }
}
