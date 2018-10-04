package zhaoyingwangluo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<ArrayList<Integer>> res = findContinueSequence(num);
        for (int i=0;i<res.size();i++) {
            ArrayList<Integer> list = res.get(i);
            String s = "[";
            for (int j = 0; j < list.size(); j++) {
                if (j == list.size() - 1) {
                    s = s + list.get(j);
                    break;
                }
                s += list.get(j)+", ";
            }
            s = s + "]";
            System.out.print(s);
        }

    }

    public static ArrayList<ArrayList<Integer>> findContinueSequence(int num) {
        if (num < 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int left = 1;
        int right = 2;
        int mid = num / 2;
        int curSum = left + right;
        while (left > 0 && right <= mid + 1) {
            if (curSum < num) {
                curSum += (++right);
            } else if (curSum > num) {
                curSum -= left;
                left++;
            } else {
                result.add(formatList(left, right));
                curSum -= left;
                left++;
            }
        }
        return result;
    }

    private static ArrayList<Integer> formatList(int left, int right) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            list.add(i);
        }
        return list;
    }
}
