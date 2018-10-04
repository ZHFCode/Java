package kedaxunfei;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/7.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        boolean[] bool = new boolean[arr.length];
        bool[0] = true;
        int ANS = 0;
        for (int i = 1;  i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                bool[i] = false;
            } else {
                bool[i] = true;
            }
        }
    }
}
