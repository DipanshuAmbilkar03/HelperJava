package Recursion;

public class arrayIsSorted {
    // method 1
    public static boolean isSorted(int arr[], int idx) {
        if(idx == arr.length-1){
            return true;
        }

        if(arr[idx] < arr[idx+1]) {
            return isSorted(arr, idx+1);
        }else{
            return false;
        }
    }

    // method 2
    public static boolean isSortedOptimized(int arr[], int idx) {
        if(idx == arr.length-1){
            return true;
        }

        if(arr[idx] >= arr[idx+1]) {
            return false;
        }
        return isSorted(arr, idx+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,13,15,21,61,74,89};
        boolean answer = isSorted(arr, 0);

        System.out.println(answer);
        System.out.println("Array is strictly increasing. As well as sorted.");
    }
}
