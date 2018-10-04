package basic_class_01;

/**
 * Created by ZHF on 2018/8/13.
 */
public class SmallSum {
    public static int smallSun(int[] arr){
        if (arr==null || arr.length<2) {
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[] arr,int l,int r){
        if (l == r){
            return 0;
        }
        int m = l + (r - l)>>1;
        return mergeSort(arr,l,m)+mergeSort(arr,m+1,r)+merge(arr,l,m,r);
    }
    public static int merge(int[] arr,int l,int m,int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        int res = 0;
        while (p1<=m && p2<=r){
            res += arr[p1] < arr[p2] ? (r-p2+1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int r = smallSun(arr);
        System.out.println(r);
    }
}
