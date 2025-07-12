public class permutationOfLetters {
    public static void permutation(String str, String permutation) {
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        // ABCD
        for(int i=0 ; i<str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            permutation(newStr, permutation+currChar);
        }
    }
    public static void main(String[] args) {
        String str = "abcd";
        permutation(str,"");
    }
}
