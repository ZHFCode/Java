package basic_class_01;

/**
 * Created by ZHF on 2018/8/13.
 */
public class QuickSort {

    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr,L + (int)(Math.random()*(R-L+1)),R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr,int L,int R){
        int less = L-1;
        int more = R;
        int cur = L;
        while (cur < more){
            if (arr[cur] < arr[R]){
                swap(arr,less+1,cur);
                less++;
                cur++;
            } else if (arr[cur] > arr[R]){
                swap(arr,more-1,cur);
                more--;
            } else {
                cur++;
            }
        }
        swap(arr,more,R);
        return new int[] {less+1,more};
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2,7,5,4,9,3,6};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
