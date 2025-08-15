public class selection {
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) { 
            System.out.print(arr[i] + "->");    
        }
    }

    public static void selection(int[] arr,int n) {
        for(int i=0; i<n-1; i++) {
            int maxEle = i;
            for(int j=i+1; j<n; j++) {
                if(arr[maxEle] > arr[j]) {
                    maxEle = j;
                }
            } 
            
            int temp = arr[i];
            arr[i] = arr[maxEle];
            arr[maxEle] = temp;
        }

        printArr(arr);
    }   

    public static void main(String[] args) {
        int arr[] = {10,2,5,1,15};
        int n = arr.length;
        
        selection(arr,n);
    }
}
