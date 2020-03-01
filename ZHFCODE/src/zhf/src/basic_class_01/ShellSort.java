package zhf.src.basic_class_01;

/**
 * Created by ZHF on 2018/8/15.
 */
public class ShellSort {
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void shellSort(int[] arr){
        if (arr==null && arr.length<2){
            return;
        }
        int N = arr.length;
        int h = 1;
        while (h < N/3){
            h = h*3+1;
        }
        while (h>=1){
            for (int i=1;i<N;i++){
                for (int j = i; j>=h && arr[j]<arr[j-h];j -= h){
                    swap(arr,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,33,55,2,4,6,3,2,7,8,5,43,7,4,67,7,8,4,6,7};
        System.out.println(arr.length+"==");
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
