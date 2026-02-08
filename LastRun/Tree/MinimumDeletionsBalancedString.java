package LastRun.Tree;
import java.util.*;

public class MinimumDeletionsBalancedString {

    public static int minimumDeletions(String s) {

        int remove_ = 0;
        int err = 0;

        for (char ch : s.toCharArray()) {

            if (ch == 'b') {
                err++;
            } else {
                remove_++;
                remove_ = Math.min(remove_, err);
            }
        }

        return remove_;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int result = minimumDeletions(s);
        System.out.println(result);

        sc.close();
    }
}
