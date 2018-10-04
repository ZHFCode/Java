package basic_class_01;

/**
 * Created by ZHF on 2018/8/13.
 */

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for (int end=arr.length-1;end>0;end--){
            for (int i=0;i<end;i++){
                if (arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a ={1,4,3,7,5};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
