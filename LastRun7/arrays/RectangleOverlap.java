public class RectangleOverlap {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec2[0] >= rec1[2]) return false;
        if (rec1[0] >= rec2[2]) return false;
        if (rec1[3] <= rec2[1]) return false;
        if (rec1[1] >= rec2[3]) return false;

        return true;
    }

    public static void main(String[] args) {

        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};

        int[] rec3 = {0, 0, 1, 1};
        int[] rec4 = {1, 0, 2, 1};

        int[] rec5 = {0, 0, 1, 1};
        int[] rec6 = {2, 2, 3, 3};

        int[] rec7 = {0, 0, 3, 3};
        int[] rec8 = {1, 1, 2, 2};

        System.out.println(isRectangleOverlap(rec1, rec2));
        System.out.println(isRectangleOverlap(rec3, rec4));
        System.out.println(isRectangleOverlap(rec5, rec6));
        System.out.println(isRectangleOverlap(rec7, rec8));
    }
}