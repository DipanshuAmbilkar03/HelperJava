// import Heap.insert;

public class bubble {
    public static int[] bubble(int[] arr) {
        int n = arr.length;
        boolean isSorted;
        for(int i=0; i<n; i++) {
            isSorted = false;
            for(int j=i+1; j<n; j++) {
                if(arr[i] < arr[j]) {
                    // swap 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    isSorted = true;
                }   
            }
            if(!isSorted) break;
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {34,654,854,564,876,436};
        int n = arr.length;
        System.out.println(bubble(arr));

        for(int j=0; j<n; j++) {
            System.out.println(arr[j]);
        }
    }
}
