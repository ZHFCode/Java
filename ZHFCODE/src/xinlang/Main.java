package xinlang;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(LCS(s1,s2));
    }

    public static int LCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int row = 0; row <= s1.length(); row++) {
            dp[row][0] = 0;
        }
        for (int columm = 0; columm <= s2.length(); columm++) {
            dp[0][columm] = 0;
        }

        for (int i = 1; i <+ s1.length() ; i++) {
            for (int j = 1; j <= s2.length() ; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
