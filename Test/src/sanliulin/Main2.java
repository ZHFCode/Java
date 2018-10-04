package sanliulin;

import java.util.*;

/**
 * Created by ZHF on 2018/8/27.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int cishu = Integer.valueOf(s1[0]);  //5
        int zhonglei = Integer.valueOf(s1[1]); // 3
        if (cishu < 0 || cishu > 2000 || zhonglei < 0 || zhonglei > 100) {
            return;
        }
        String s_arr = scanner.nextLine();
        String[] s2 = s_arr.split(" ");
        int[] kanhua = new int[s2.length]; //0-4 5次
        for (int i = 0; i < kanhua.length; i++) {
            kanhua[i] = Integer.valueOf(s2[i]);
        }

        int jisuancishu = Integer.valueOf(scanner.nextLine());

        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String[] strings = a.split(" ");
            int L = Integer.valueOf(strings[0]);
            int R = Integer.valueOf(strings[1]);
            HashSet<Integer> set = new HashSet<>();
            for (int i = L; i <= R; i++) {
                set.add(kanhua[i - 1]);
            }
            System.out.println(set.size());
        }

    }
}
