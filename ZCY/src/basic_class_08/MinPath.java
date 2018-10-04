package basic_class_08;

/**
 * Created by ZHF on 2018/8/25.
 * 我他妈这么久想不到呢！！
 */
public class MinPath {
    public static int minPath(int[][] matrix,int i,int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + minPath(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + minPath(matrix, i + 1, j);
        }
        int right = minPath(matrix, i, j + 1);
        int down = minPath(matrix, i + 1, j);
        return matrix[i][j] + Math.min(right, down);
    }
}
