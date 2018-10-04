package basic_class_01;

/*
堆排序，大根堆
 */
/**
 * Created by ZHF on 2018/8/14.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,2,3,6,9,5,7,8,8};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void heapSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
            //到这一部分是将数组建立成堆
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heapify(arr,0,heapSize);  //heapify在0-heapSize-1的区间上操作
            swap(arr,0,--heapSize);
        }
    }
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index - 1) / 2;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void heapify(int[] arr,int index,int heapSize){    //在0~heapSize-1上操作
        int left = index*2+1;
        while (left<heapSize){
            int largest = left+1 < heapSize && arr[left] < arr[left+1] ? left+1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index*2+1;
        }
    }
}
