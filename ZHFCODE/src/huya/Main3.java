package huya;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/13.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                if (map.get(chars[i]) + 1 == 3 && chars[i]!=' ') {
                    System.out.println(chars[i]);
                    return;
                }
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
    }
}
