public class insertion {
    public static void insertion(int[] arr,int n) {
        for(int i=1;i<n;i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >=0 && arr[j] > arr[key]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }

        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+"->");
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,2,5,1,15};
        int n = arr.length;
        insertion(arr,n);
    }
}
