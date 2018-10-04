package yixin;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        String source = s[0];
        String target = s[1];
        System.out.println(getIndexOf(source, target));
    }
    public static int getIndexOf(String s1, String s2) {
        if (s1 == s2) {
            return 0;
        }
        int[] next = getNextArr(s2);
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();
        int index1 = 0;
        int index2 = 0;

        while (index1 < charS1.length && index2 < charS2.length) {
            if (charS1[index1] == charS2[index2]) {
                index1++;
                index2++;
            } else if (next[index2] == -1) {
                index1++;
            } else {
                index2 = next[index2];
            }
        }
        return index2 == charS2.length ? index1 - index2 : -1;
    }

    public static int[] getNextArr(String s2) {
        if (s2 == null) {
            return null;
        }
        char[] charS2 = s2.toCharArray();
        if (charS2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[charS2.length];
        next[0] = -1;
        next[1] = 0;
        int cur = 2;
        int back = 0;
        while (cur < next.length) {
            if (charS2[cur - 1] == charS2[back]) {
                next[  cur++] = ++back;
            } else if (back > 0) {
                back = next[back];
            } else {
                next[cur++] = 0;
            }
        }
        return next;
    }

}
