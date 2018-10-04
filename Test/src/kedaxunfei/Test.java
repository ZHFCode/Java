package kedaxunfei;

/**
 * Created by ZHF on 2018/9/7.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*** 说明：* 所有测试数据均已输出正确结果！* ^_^*/
public class Test {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int count = 0;
            int n = in.nextInt();
            int X = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                list.add(in.nextInt());
            }
            Collections.sort(list);
            //System.out.println(AverageOfList(list));
            //System.out.println(list);
            // 都成立的情况下
            if (AverageOfList(list) >= X) {
                resList.add(count);
                continue;
            }            // 不成立：开始尝试调整每个list
            for (int c = 0; c < list.size(); c++) {
                list.set(c, 100);
                count++;
                if (AverageOfList(list) >= X) {
                    resList.add(count);
                    break;
                }
            }
        }
        if (resList.size() == 0) {
            return;
        }
        for (int i = 0; i < resList.size(); i++) {

            System.out.println(resList.get(i));
        }
}

    private static double AverageOfList(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / (double) list.size();
    }
}