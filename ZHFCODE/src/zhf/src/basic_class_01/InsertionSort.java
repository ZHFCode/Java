package zhf.src.basic_class_01;

/**
 * Created by ZHF on 2018/8/13.
 */
public class InsertionSort {

    public static void swap(int[] arr, int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void insertionSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        // 从后往前比较，j--;
        for (int i = 1; i < arr.length; i++) {
            for (int j=i-1; j>=0 && arr[j]>arr[j+1]; j--){
                swap(arr,j,j+1);
            }
        }
    }
    public static void main(String[] args) {
        int[] a ={1,4,34,5,44,51,7};
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
