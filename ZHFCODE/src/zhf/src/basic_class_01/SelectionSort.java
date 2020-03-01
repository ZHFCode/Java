package zhf.src.basic_class_01;

/**
 * Created by ZHF on 2018/8/13.
 */
public class SelectionSort {
    public static void selectedSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for (int i=0;i<arr.length;i++){
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] a ={1,4,34,5,44,51,7};
        selectedSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
