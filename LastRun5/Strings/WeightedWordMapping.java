import java.util.*;

public class WeightedWordMapping {

    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for (String str : words) {
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += weights[str.charAt(i) - 'a'];
            }

            sum %= 26;
            sb.append((char) ('z' - sum));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"abc", "de", "xyz"};

        int[] weights = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18,
            19, 20, 21, 22, 23, 24, 25, 26
        };

        String result = mapWordWeights(words, weights);
        System.out.println(result);
    }
}