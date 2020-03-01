package zhf.src.basic_class_03;

/**
 * Created by ZHF on 2018/8/17.
 * @author ZHF
 */
public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }


    public static int[] printMatrix(int[][] mat, int n, int m) {
        int[] arr = new int [n*m];
        //hang记录你的行数，count记录的是你返回的字符数组的长度
        int hang = 0;
        int count = 0;
        //偶数行顺序，奇数行倒序
        for(int i = 0; i < mat.length; i++ ){
            for(int j = 0; j < mat[i].length; j++){
                //判断数奇数行还是偶数行
                if(hang%2 == 0){
                    arr[count++] = mat[i][j];
                }else{
                    arr[count++] = mat[i][m-1-j];
                }
            }
            //写完了一行，行数需要+1
            hang++;
        }
        return arr;
    }

    private static int[] zhizixing(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int row = 0;
        int index = 0;
        int[] res = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row % 2 != 0) {
                    res[index++] = arr[i][n -1-j];
                } else {
                    res[index++] = arr[i][j];
                }
            }
            row++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//        printMatrixZigZag(matrix);
        int[] a = zhizixing(matrix);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
