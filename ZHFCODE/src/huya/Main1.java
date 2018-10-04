package huya;

import java.util.Scanner;

/**
 * Created.ou   .prin    by ZHF on 2018/9/13.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            s = "";
            for (int i = 0; i < strings.length; i++) {
                s += strings[i];
            }
            if (s.length() <= 8) {
                System.out.println(s);
            } else if (s.length() > 8 && s.length() <= 14) {
                String s1 = s.substring(0, 6);
                String s2 = s.substring(6, s.length());
                String ans = s1 + " " + s2;
                System.out.println(ans);
            } else if (s.length() > 14 && s.length() <= 18) {
                String s1 = s.substring(0, 6);
                String s2 = s.substring(6, 14);
                String s3 = s.substring(14, s.length());
                String ans = s1 + " " + s2 + " " + s3;
                System.out.println(ans);
            }
        }
        scanner.close();
    }
}
