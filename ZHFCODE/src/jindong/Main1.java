package jindong;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/9.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int example = scanner.nextInt();
        while (example > 0) {
            if (example % 2 == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            example--;
        }
    }

    public static boolean isNum(int[][] matrix,int x,int N) {
        for (int i = N-1; i >=0; i--) {
            if (matrix[x - i][x] == 1 && matrix[x][x - i] == 1) {

            } else {
                return false;
            }
        }
        return true;
    }
}
