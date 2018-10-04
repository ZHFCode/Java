package shunfeng;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int lens1 = s1.length();
        int lens2 = s2.length();

        int diff = Math.abs((lens1 - lens2));
        if (lens1 > lens2) {
            int commen = getLCSLength(s1, s2);
            System.out.println(lens1 - diff);
        } else {
            int commen = getLCSLength(s2, s1);
            System.out.println(lens2 - commen);
        }

    }

    public static int getLCSLength(String str, String str2){
        char[] ary = str.toCharArray();
        char[] ary2 = str2.toCharArray();

        int[][] temp = new int[ary.length][ary2.length];	//声明一个二维数组，存储最长公共子串长度
        int length = 0;	//最长公共子串长度
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary2.length; j++) {
                if(ary[i] == ary2[j]){
                    if(i > 0 && j > 0){
                        temp[i][j] = temp[i-1][j-1] + 1;
                    }else{
                        temp[i][j] = 1;
                    }

                    if(temp[i][j] > length){	//当前元素值大于最大公共子串长度
                        length = temp[i][j];
                    }
                }else{
                    temp[i][j] = 0;
                }
            }
        }
        return length;
    }

}
