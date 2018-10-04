package yixin;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/16.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        int k = Integer.valueOf(ss[2]);
        String key_line = scanner.nextLine();
        String[] key = key_line.split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < key.length; i++) {
            set.add(key[i]);
        }

        int p = 2 * m;
        while (p > 0) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String[] web_detail = s2.split(" ");
            int index = 0;
            for (int i = 0; i < web_detail.length; i++) {
                if (set.contains(web_detail[i])) {
                    index++;
                }
            }
            if (index >= k) {
                System.out.println(s1);
            } else {
                System.out.println();
            }
            p = p - 2;
        }
    }
}
