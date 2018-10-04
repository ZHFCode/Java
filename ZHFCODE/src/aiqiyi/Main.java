package aiqiyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        ArrayList<Integer> qian = new ArrayList<>();
        ArrayList<Integer> hou = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            qian.add(Integer.valueOf(chars[i]));
        }
        for (int i = chars.length-1; i >= chars.length-3 ; i--) {
            hou.add(Integer.valueOf(chars[i]));
        }
        int sumQian = 0;
        int sumHou = 0;
        for (int i:qian
             ) {
            sumQian += qian.get(i);
        }
        for (int i:hou
             ) {
            sumHou += hou.get(i);
        }
        Collections.sort(qian);
        Collections.sort(hou);
        int diff = Math.abs((sumHou - sumQian));
        int index1 = 0;
        for (int i:qian
             ) {
            if (index1 <= 0) {
                break;
            }
            int x = 9 - i;
            index1 = index1 - x;
            index1++;
        }
        int index2 = 0;

        System.out.println(Math.min(index1, index2));
    }
}
