package zhf.src.basic_class_03;

/**
 * Created by ZHF on 2018/8/17.
 */
public class RotateMatrix {
    public static void rotateMatrix(int[][] arr){
        int tr = 0;
        int tc = 0;
        int dr = arr.length-1;
        int dc = arr[0].length-1;
        while (dr>tr && dc>tc){
            rotateMatrix(arr,tr++,tc++,dr--,dc--);
        }
    }
    public static void rotateMatrix(int[][] arr,int tr,int tc,int dr,int dc){
        int times = dr-tr;
        for (int i=0;i!=times;i++){
            int tmp = arr[tr][tc+i];
            arr[tr][tc+i] = arr[dr-i][tc];
            arr[dr-i][tc] = arr[dr][dc-i];
            arr[dr][dc-i] = arr[tr+i][dc];
            arr[tr+i][dc] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(arr);
        for (int i =0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
