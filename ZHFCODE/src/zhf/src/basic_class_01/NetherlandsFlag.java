package zhf.src.basic_class_01;


/**
 * Created by ZHF on 2018/8/13.
 */
public class NetherlandsFlag {
    public static int[] partion(int[] arr, int L, int R, int num){
        int less = L-1;
        int more = R+1;
        int cur = L;
        while (cur < more){
            if (arr[cur]<num){
                swap(arr,less+1,cur);
                less++;
                cur++;
            } else if (arr[cur]>num){
                swap(arr,more-1,cur);
                more--;
            } else {
                cur++;
            }
        }
        return new int[] {less+1,more-1};
    }
    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,5,6,7};
        int[] res = partion(arr,0,arr.length-1,4);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
