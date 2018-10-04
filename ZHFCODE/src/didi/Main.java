package didi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int np = scanner.nextInt();
        int nq = scanner.nextInt();
        int nr = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < np; i++) {
            sb.append("P");
        }
        for (int i = 0; i < nq; i++) {
            sb.append("Q");
        }
        for (int i = 0; i < nr; i++) {
            sb.append("R");
        }
        String target = sb.toString();
        HashSet<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        permutations(target, set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            int len = s.length();
            boolean flag = true;
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(s);
            }
        }
        for (String s:result
             ) {
            System.out.print(s+" ");
        }
    }

    public static void permutations(String s,HashSet<String> list) {
        permutation(s.toCharArray(),0,list);
    }

    public static void permutation(char[] chars, int i,HashSet<String> list) {
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            permutation(chars,i+1,list);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
