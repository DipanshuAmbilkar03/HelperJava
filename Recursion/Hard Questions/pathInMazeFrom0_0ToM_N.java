public class pathInMazeFrom0_0ToM_N {
    public static int pathInAMaze(int i,int j, int n,int m) {
        if(i == n || j == m) {
            return 0;
        }
        if(i == n-1 && j == m-1) {
            return 1;
        } 
        // move dowm 
        int downPath = pathInAMaze(i+1, j, n, m);
        // move right
        int rightPath = pathInAMaze(i,j+1, n, m);

        return downPath + rightPath;
    } 
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        int result = pathInAMaze(0, 0, n, m);
        System.out.println("Total paths from (0,0) to ("+m+","+n+") is = "+result);
    }
}
