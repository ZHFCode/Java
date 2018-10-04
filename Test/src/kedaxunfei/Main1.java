package kedaxunfei;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/7.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        int index = N;
        while (index > 0) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            String[] aa = a.split(" ");
            int num = Integer.valueOf(aa[0]);
            int mean = Integer.valueOf(aa[1]);

            String[] s = b.split(" ");
            int[] score = new int[s.length];
            for (int i = 0; i < score.length; i++) {
                score[i] = Integer.valueOf(s[i]);
            }


            long meanTotalScore = num * mean;
            long totalScore = 0;
            for (int i = 0; i < score.length; i++) {
                totalScore += score[i];
            }
            long diff = meanTotalScore - totalScore;
            int ans = 0;
            if (diff <= 0) {
                System.out.println(0);
            }
            while (diff > 0) {
                int minIndex = getMinIndex(score);
                int min = score[minIndex];
                int d = 100-min;
                if (diff > d) {
                    diff = diff - d;
                    score[minIndex] = min + d;
                    ++ans;
                } else {
                    ++ans;
                }
            }
            --index;
            System.out.println(ans);
        }
    }

    public static int getMinIndex(int[] arr) {
        int index = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
