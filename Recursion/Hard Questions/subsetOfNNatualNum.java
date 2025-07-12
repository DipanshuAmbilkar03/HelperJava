import java.util.ArrayList;

public class subsetOfNNatualNum {
    public static void printSubset(ArrayList<Integer> subset) {
        for(int i=0; i<subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }
    public static void subsetNNatNum(int n, ArrayList<Integer> subset) {
        if(n == 0) {
            // printSubset(subset);
            System.out.println(subset);
            return;
        }

        // no added
        subset.add(n);
        subsetNNatNum(n-1, subset);

        subset.remove(subset.size()-1);
        subsetNNatNum(n-1, subset);
    }
    public static void main(String[] args) {
        ArrayList<Integer> subset = new ArrayList<>();
        subsetNNatNum(3, subset);
    }
}
