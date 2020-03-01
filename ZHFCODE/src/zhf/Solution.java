package zhf;

/**
 * Created by ZHF on 2018/9/14.
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null){
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int L = 0;
        int R = array.length - 1;
        int ans = -1;
        while (L < R ) {
            if (R - L == 1 && array[R] < array[L]) {
                ans = array[R];
            }
            int Mid = (R - L) / 2 + L;
            int targrt = array[Mid];
            if (targrt > array[L]) {
                L = Mid;
            }
            if ( targrt < array[R]) {
                R = Mid;
            }
        }
        return ans;
    }
}
