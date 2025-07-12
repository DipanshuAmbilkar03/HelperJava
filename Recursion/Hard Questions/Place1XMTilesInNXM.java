public class Place1XMTilesInNXM {
    public static int placeTilesToFillNXMPlace(int n, int m)     {
        if(n == m) {
            return 2;
        }

        if(n < m) {
            return 1;
        }

        //Tile placed vertical 
        int vertical = placeTilesToFillNXMPlace(n-m, m);

        //Tile placed horizontal 
        int horizontal = placeTilesToFillNXMPlace(n-1, m);

        return vertical + horizontal;
    }
    public static void main(String[] args) {
        System.out.println(placeTilesToFillNXMPlace(4,2 ));
    }   
}
