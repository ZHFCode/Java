package basic_class_03;

/**
 * Created by ZHF on 2018/8/17.
 */
public class PrintMatrixSpiralOrder {
    public static void printMatrixSpiralOrder(int[][] arr){
        int tr = 0;
        int tc = 0;
        int dr = arr.length-1;
        int dc = arr[0].length-1;
        while (dr>tr && dc>tc){
            printMatrixSpiralOrder(arr,tr++,tc++,dr--,dc--);
        }
    }
    private static void printMatrixSpiralOrder(int[][] arr,int tr,int tc,int dr,int dc){
        if (tr == dr){
            for (int i=tc;i<=dc;i++){
                System.out.print(arr[tr][i]+" ");
            }
        } else if (tc == dc){
            for (int i = tr;i<=dr;i++){
                System.out.print(arr[i][tc]+" ");
            }
        } else {
            int cur_row = tr;
            int cur_col = tc;
            while (cur_col != dc){
                System.out.print(arr[tr][cur_col]+" ");
                cur_col++;
            }
            while (cur_row != dr){
                System.out.print(arr[cur_row][dc]+" ");
                cur_row++;
            }
            while (cur_col != tc){
                System.out.print(arr[dr][cur_col]+" ");
                cur_col--;
            }
            while (cur_row != tr){
                System.out.print(arr[cur_row][tc]+" ");
                cur_row-- ;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrixSpiralOrder(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int tr = 0;
        int tc = 0;
        int dr = matrix.length;
        int dc = matrix.length;
        while (dr > tr && dc > tc) {
            printMatrix(matrix, tr++, tc++, dr--, dc--);
        }
    }
    public static void printMatrix(int[][] matrix, int tr, int tc, int dr, int dc) {
        if (tr == dr) {
            for (int i = tc; i <= dc; i++) {
                System.out.print(matrix[tr][i]);
            }
        } else if (tc == dc) {
            for (int i = tr; i <= dr; i++) {
                System.out.print(matrix[i][tc]);
            }
        } else {
            int cur_row = tr;
            int cur_col = tc;
            while (cur_col != dc) {
                System.out.print(matrix[tr][cur_col]+" ");
                cur_col++;
            }
            while (cur_row != dr) {
                System.out.print(matrix[cur_row][dc]+" ");
                cur_row++;
            }
            while (cur_col != tc) {
                System.out.print(matrix[dr][cur_col]+" ");
                cur_col--;
            }
            while (cur_row != tr) {
                System.out.print(matrix[cur_row][tc]+" ");
                cur_row--;
            }
        }
    }
}
