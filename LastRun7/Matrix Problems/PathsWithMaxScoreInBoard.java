import java.util.*;

public class PathsWithMaxScoreInBoard {

    public static int[] pathsWithMaxScore(List<String> board) {

        int mod = 1_000_000_007;
        int n = board.size();

        int[][] sum = new int[n][n];
        int[][] count = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(sum[i], -1);
        }

        sum[0][0] = 0;
        count[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board.get(i).charAt(j) == 'X') continue;
                if (i == 0 && j == 0) continue;

                int best = -1;
                int ways = 0;

                int[][] dir = {{-1, 0}, {0, -1}, {-1, -1}};

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < 0 || nj < 0) continue;
                    if (sum[ni][nj] == -1) continue;

                    int val = sum[ni][nj];

                    if (val > best) {
                        best = val;
                        ways = count[ni][nj];
                    } else if (val == best) {
                        ways = (ways + count[ni][nj]) % mod;
                    }
                }

                if (best == -1) continue;

                int add = 0;
                char ch = board.get(i).charAt(j);
                if (Character.isDigit(ch)) {
                    add = ch - '0';
                }

                sum[i][j] = best + add;
                count[i][j] = ways;
            }
        }

        int totalSum = sum[n - 1][n - 1];
        int totalWays = count[n - 1][n - 1];

        if (totalWays == 0) return new int[]{0, 0};

        return new int[]{totalSum, totalWays};
    }

    public static void main(String[] args) {

        List<String> board1 = Arrays.asList(
                "E23",
                "2X2",
                "12S"
        );

        List<String> board2 = Arrays.asList(
                "E12",
                "1X1",
                "21S"
        );

        System.out.println(Arrays.toString(pathsWithMaxScore(board1)));
        System.out.println(Arrays.toString(pathsWithMaxScore(board2)));
    }
}