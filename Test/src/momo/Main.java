package momo;

        import java.util.Scanner;

/**
 * Created by ZHF on 2018/8/30.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m_n = scanner.nextLine();
        String[] strings = m_n.split(" ");
        int m = Integer.valueOf(strings[0]);
        int n = Integer.valueOf(strings[1]);
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = chars[j] + "";
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == ".") {
                    continue;

                } else if (matrix[i][j] == "x") {
                    continue;
                } else { //matrix[i][j] == "o"

                    if (i + 1 < m && matrix[i + 1][j] == ".") {
                        matrix[i][j] = ".";
                        matrix[i + 1][j] = "o";
                    }
                    if (i + 1 < m && matrix[i + 1][j] == "x") {
                        continue;
                    }
                    if (i + 1 < m && matrix[i + 1][j] == "0") {
                        continue;
                    }
                    if (i == (m - 1) && matrix[i][j] == "o") {
                        for (int k = i; k >0 ; k--) {
                            if (matrix[k][j] == "o") {
                                matrix[k][j] = ".";
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }


}
