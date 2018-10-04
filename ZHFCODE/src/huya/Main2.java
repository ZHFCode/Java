package huya;

import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/13.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                if (i != strings.length - 1 || i != 0) {
                    sb.append(strings[i]);
                    sb.append(" ");
                } else {
                    sb.append(strings[i]);
                }
            }
            System.out.println(sb.toString());

        }
    }

}
