package pdd;

import sun.rmi.log.LogInputStream;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.valueOf(s.nextInt());
        String list_input = s.nextLine();
        String[] arr = list_input.split(" ");
        int[] list = new int[arr.length];
        for (int i=0;i<list.length;i++){
            list[i] = Integer.valueOf(arr[i]);
        }

        System.out.print(test(N, list));

    }
    public static int test(int N,int[] arr){
        int result = 0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                result = result+diff(arr,i,j);
            }
        }
        return result;
    }
    public static int diff(int[] arr,int start,int end){
        int min = arr[start];
        int max = arr[start];
        for (int k =start;k<=end;k++){
            if (arr[k] < min){
                min  = arr[k];
            } else if (arr[k] > max){
                max = arr[k];
            }
        }
        return Math.abs(max-min);
    }
}
