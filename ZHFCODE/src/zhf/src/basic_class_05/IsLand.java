package zhf.src.basic_class_05;

/**
 * Created by ZHF on 2018/8/23.
 */
public class IsLand {
    public static int countIsand(int[][] arr) {
        int row = arr.length;
        int columns = arr[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr, i, j, row, columns);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] arr, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2;
        infect(arr, i + 1, j, N, M);
        infect(arr, i - 1, j, N, M);
        infect(arr, i, j + 1, N, M);
        infect(arr, i, j - 1, N, M);
    }
    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIsand(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIsand(m2));

    }
}
