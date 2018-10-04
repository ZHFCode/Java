/**
 * Created by ZHF on 2018/9/10.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(arr, 6));
    }

    public static int binarySearch(int[] arr, int key) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            mid = (end - start) / 2 + start;
            if (key < arr[mid]) {
                end = mid-1;
            } else if (key > arr[mid]) {
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
