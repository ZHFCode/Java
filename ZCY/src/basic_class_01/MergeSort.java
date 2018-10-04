package basic_class_01;

/**
 * Created by ZHF on 2018/8/13.
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        sortPocess(arr,0,arr.length-1);
    }
    private static void sortPocess(int[] arr,int l,int r){
        if (l==r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        sortPocess(arr,l,mid);
        sortPocess(arr,mid+1,r);
        merge(arr,l,r,mid);
    }
    private static void merge(int[] arr,int l,int r,int mid){
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //这时候，p1或者p2必有一个越界，将没有越界的部分中剩下的复制到help数组中
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,2,5,7,1,0};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
