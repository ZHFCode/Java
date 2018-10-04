package dianxin;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String ans = "1";
        for (int i = 0; i < N; i++) {
            ans = multiply(ans, (N - i) + "");
        }
        System.out.println(ans);
        char[] chars = ans.toCharArray();
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            r += chars[i] - '0';
        }
        System.out.println(r);
    }
    public static String multiply(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] n1 = new int[c1.length];
        int[] n2 = new int[c2.length];

        for (int i = 0; i < n1.length; i++) {
            n1[i] = c1[i] - '0';
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = c2[i] - '0';
        }

        int[] result = new int[n1.length + n2.length];

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }

        for (int i = result.length-1; i >0 ; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        String s = "";
        for (int i = 0; i < result.length-1; i++) {
            s += ""+result[i];
        }
        return s;
    }
}
