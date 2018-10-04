package sanliulin;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 2 || n > 1000) {
            return;
        }
        int[] x_arr = new int[n];
        int[] y_arr = new int[n];
        int index = 0;
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] ss = s.split(" ");
            int x = Integer.valueOf(ss[0]);
            int y = Integer.valueOf(ss[1]);
            x_arr[index] = x;
            y_arr[index] = y;
            index++;
        }
        long x_min = x_arr[0];
        long x_max = x_arr[0];
        long y_min = y_arr[0];
        long y_max = y_arr[0];
        for (int i = 0; i < x_arr.length; i++) {
            if (x_min > x_arr[i]) {
                x_min = x_arr[i];
            }
            if (x_max < x_arr[i]) {
                x_max = x_arr[i];
            }
            if (y_min > y_arr[i]) {
                y_min = y_arr[i];
            }
            if (y_max < y_arr[i]) {
                y_max = y_arr[i];
            }
        }

        long result = 0;
        long row = Math.abs((x_max - x_min));
        long col = Math.abs((y_max - y_min));
        if (row > col) {
            result = row * row;
        } else {
            result = col*col;
        }

        System.out.println(result);
    }
}
