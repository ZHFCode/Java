package baidu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ZHF on 2018/9/11.
 */
public class Solution1
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    char[] rangeFrequent(String str, int pair, int[][] rangeLR)
    {
        // WRITE YOUR CODE HERE
        char[] retCharArr = new char[pair];
        for (int i = 0; i < rangeLR.length; i++) {
            retCharArr[i] = dealCore(str.substring(rangeLR[i][0] - 1, rangeLR[i][1]));
        }
        ArrayList<Integer> a = new ArrayList<>();
        return retCharArr;
    }

    private char dealCore(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        char ret = temp[0];
        int retCount = 1;
        for (int i = 0; i < temp.length; ) {
            int count = 1;
            for (int j = i+1; j <temp.length ; j++) {
                if (temp[j] != temp[i]) {
                    break;
                }
                count++;
            }
            if (retCount < count) {
                retCount = count;
                ret = temp[i];
            }
            i += count;
        }
        return ret;
    }
    // METHOD SIGNATURE ENDS
}