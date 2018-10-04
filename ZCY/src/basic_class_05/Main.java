package basic_class_05;

import java.util.*;

/*
华为机笔试
 */

/**
 * Created by ZHF on 2018/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(test(s));
    }
    public static int test(String s){
        if (s == null){
            return 0;

        }
        int count = 0;
        char[] res = s.toCharArray();
        String[] resStr = new String[res.length];
        for (int i = 0; i < resStr.length; i++) {
            resStr[i] = res[i]+"";
        }
        TreeSet<Integer> set = new TreeSet<>();
        if (res.length<2){
            return 0;
        }
        if (res.length==2){
            if (resStr[0].equals("(") && resStr[1].equals(")")){
                return 2;
            } else {
                return 0;
            }
        }
        for (int i = 1; i < resStr.length; i++) {
            if (resStr[i - 1].equals("(") && resStr[i].equals(")")) {
                count++;
            } else if (resStr[i - 1].equals(")") && resStr[i].equals("(")) {
                count = count + 0;
            } else {
                set.add(count);
                count=0;
            }
            if (i==resStr.length-1){
                set.add(count);
            }
        }
        return set.last()*2;
    }

}
