package xunlei;

import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by ZHF on 2018/9/12.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a,b,c;
        int count = 0;
        for (a = 0; a <= N; a++) {
            for (b = 0; b <= N; b++) {
                for (c = 0; c <= 10; c++) {
                    if (a * a + b * b == c * c && condition(a,b,c,N) && huzhiOdd(a,b,c)) {
                        if (rgcd(a, b) == 1 && rgcd(a, c) == 1 && rgcd(b, c) == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean huzhiOdd(int a, int b, int c) {
        if (a > 4 && a % 2 == 0) {
            int n = a / 2;
            if ((b == pow(n, 2) - 1 && c == pow(n, 2) + 1) || (c == pow(n, 2) - 1 && b == pow(n, 2) + 1)) {
                return true;
            }
        }
        return false;
    }


    public static boolean condition(int a, int b, int c,int N) {
        if (a > 0 && a <= b && b <= c && c <= N) {
            return true;
        }
        return false;
    }

    public static int rgcd(int a, int b) {
        if (b != 0) {
            return rgcd(b, a % b);
        }
        return a;
    }
}
