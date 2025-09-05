

public class reverseDuplicate {
    public static int mergeSort(int[] arr) {
        int i=0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[i] < arr[j]) {
                int temp = arr[i+1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,1,1,2,2,3};
        System.out.println(mergeSort(arr));
    }
}