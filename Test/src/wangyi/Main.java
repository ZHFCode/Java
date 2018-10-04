package wangyi;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int example = scanner.nextInt();
        while (example > 0) {

            int N = scanner.nextInt();
            int M = scanner.nextInt();
            if (N <= 0 || N > 1000000000 || M <= 0 || M > 1000000000) {
                return;
            }
            boolean[][] matrix = new boolean[N][M]; //

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    infection(matrix,i,j,N,M);
                }
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == true) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            example--;
        }
        scanner.close();
    }

    public static void infection(boolean[][] matrix,int i,int j,int row,int col) {
        matrix[i][j] = !matrix[i][j];
        if (i - 1 >= 0 && (j >= 0 && j <= col - 1)) {
            matrix[i - 1][j] = !matrix[i - 1][j];
        }
        if (i + 1 <= row - 1 && (j >= 0 && j <= col - 1)) {
            matrix[i + 1][j] = !matrix[i + 1][j];
        }
        if (j - 1 >= 0 && (i >= 0 && i <= row - 1)) {

            matrix[i][j - 1] = !matrix[i][j - 1];
        }
        if (j + 1 < col && (i >= 0 && i <= row - 1)) {
            matrix[i][j + 1] = !matrix[i][j + 1];
        }

        if (i - 1 >= 0 && i - 1 <= row - 1 && j - 1 >= 0 && j - 1 <= col - 1) {
            matrix[i - 1][j - 1] = !matrix[i - 1][j - 1];
        }
        if (i - 1 >= 0 && i - 1 <= row - 1 && j + 1 < col && j + 1 >= 0) {
            matrix[i - 1][j + 1] = !matrix[i - 1][j + 1];
        }
        if (i + 1 < row && i + 1 >= 0 && j - 1 >= 0 && j - 1 <= col - 1) {
            matrix[i + 1][j - 1] = !matrix[i + 1][j - 1];
        }
        if (i + 1 < row && i + 1 >= 0 && j + 1 < col && j + 1 >= 0) {
            matrix[i + 1][j + 1] = !matrix[i + 1][j + 1];
        }
    }
}
