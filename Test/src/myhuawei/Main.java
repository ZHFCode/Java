package myhuawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);

        System.out.println(test(s1, s2));
    }

    public static String test(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        String s = null;
        HashSet<Character> set1 = new HashSet<>();
        char[] char1 = s1.toCharArray();
        HashSet<Character> set2 = new HashSet<>();
        char[] char2 = s2.toCharArray();

        for (int i = 0; i < char1.length; i++) {
            set1.add(char1[i]);
        }

        for (int i = 0; i < char2.length; i++) {
            set2.add(char2[i]);
        }

        Iterator<Character> iterator = set2.iterator();
        while (iterator.hasNext()) {
            Character c = iterator.next();
            if (!set1.contains(c)) {
                s = "false";
            }
        }
        s = "true";
        return s;
    }
}
