package dianxin;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/10.
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(reverse(n));
        System.out.println(reverse(-4790));
    }

    public static int reverse(int x) {
        boolean negative = x < 0;
        if (negative)
            x = -x;
        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static int reverseInt(int n) {
        boolean flag = n < 0;
        if (flag) {
            n = -n;
        }
        int result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return n;
    }
}