class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        int max = 0;
        int len = s.length();
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                int product = (s.charAt(i)-'0') * (s.charAt(j)-'0');
                max = Math.max(product,max);
            }
        }
        return max;
    }
}