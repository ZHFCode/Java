package bilibili;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String erer = "2";
        String sansan = "3";

        int num = 0;


    }

    public static void subProcess(int x,int N) {
        if (x == N) {
            return;
        }
        x += two(x);
        subProcess(x,N);
    }

    public static int two(int x) {
        if ((2 * x + 1) < Integer.MAX_VALUE) {
            return 2 * x + 1;
        }
        return 0;
    }

    public static int three(int x) {
        if ((2 * x + 2) < Integer.MAX_VALUE) {
            return 2 * x + 2;
        }
        return 0;
    }
}
