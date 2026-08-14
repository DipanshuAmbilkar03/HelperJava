import java.util.*;

public class MaximumMeetings {

    static class Meeting {
        int start, finish, index;

        Meeting(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }

    public static ArrayList<Integer> maxMeetings(int[] s, int[] f) {

        List<Meeting> list = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            list.add(new Meeting(s[i], f[i], i + 1));
        }

        Collections.sort(list, (a, b) -> {
            if (a.finish == b.finish) {
                return a.index - b.index;
            }
            return a.finish - b.finish;
        });

        ArrayList<Integer> ans = new ArrayList<>();
        int lastFinish = -1;

        for (Meeting meeting : list) {
            if (meeting.start > lastFinish) {
                ans.add(meeting.index);
                lastFinish = meeting.finish;
            }
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] s1 = {1, 3, 0, 5, 8, 5};
        int[] f1 = {2, 4, 6, 7, 9, 9};

        int[] s2 = {10, 12, 20};
        int[] f2 = {20, 25, 30};

        int[] s3 = {1, 2, 3, 4};
        int[] f3 = {2, 3, 4, 5};

        System.out.println(maxMeetings(s1, f1));
        System.out.println(maxMeetings(s2, f2));
        System.out.println(maxMeetings(s3, f3));
    }
}