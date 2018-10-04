package huawei;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/8/29.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        int length = arr.length;
        boolean flag = false;
        int sum = 0;
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == '-') {
                flag = !flag;
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                num *= 10;
                num += arr[i] - '0';
            } else {
                sum += flag ? num : -num;
                num = 0;
                flag = true;
            }
        }
        sum += flag ? num : -num;
        System.out.println(sum);
    }
}