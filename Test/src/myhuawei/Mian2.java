package myhuawei;

import java.util.*;

/**
 * Created by ZHF on 2018/9/5.
 */
public class Mian2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        int flag = 0;

        for (int i = str1.length() - 1, j = str2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int c = i >= 0 ? str1.charAt(i) - 'a' : 0;
            int d = j >= 0 ? str2.charAt(j) - 'a' : 0;
            char val = (char) ('a' + (c + d + flag) % 26);
            flag = (c + d + flag) / 26;
            result.insert(0, val);
        }
        if (flag != 0) {
            result.insert(0, (char) ('a' + flag));
        }
        System.out.println(result.toString());
    }

    public static boolean hasSyntaxError(String s) {

        return false;
    }
}