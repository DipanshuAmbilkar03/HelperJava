public class update_MinMaxST {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static void builtTree(int i,int arr[], int si, int sj) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        builtTree(2*i+1,arr, si, mid);
        builtTree(2*i+2,arr, mid+1, sj);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int maxUtil(int i,int si,int sj,int qi,int qj) {
        // non overlap
        if (si > qi || sj < qj) {
            return Integer.MIN_VALUE;
        }
        // completely overlap
        else if(qj <= sj && qi >= si) {
            return tree[i];
        }
        // partial overlap 
        int mid = (si + sj) / 2;
        int left = maxUtil(2*i+1, si, mid, qi, qj);
        int right = maxUtil(2*i+2, mid+1, sj, qi, qj);
        
        return Math.max(left, right);
    }

    public static int getMax(int arr[],int qi,int qj) {
        int n = arr.length;
        return maxUtil(0,0, n-1, qi, qj);
    }

    public static void updateUtil(int i,int si,int sj,int idx,int newVal) {
        if(idx < si || idx > sj) {
            return;
        }

        tree[i] = Math.max(tree[i], newVal);
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateUtil(2*i+1, si,mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    }

    public static void update(int[] arr, int idx,int newVal) {
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, newVal);
    }

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;

        init(n);
        builtTree(0, arr, 0, n-1);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        int max = getMax(arr, 2, 5);
        System.out.println("Maximum value in the tree is : "+max);

        update(arr, 2, 20);

        max = getMax(arr, 2, 5);
        System.out.println("Maximum value in the tree is : "+max);

    }
}
