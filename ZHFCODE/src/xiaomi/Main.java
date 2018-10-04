package xiaomi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag == true ? 1 : 0);
        scanner.close();
    }


}
