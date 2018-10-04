package oppo;

import java.util.*;

/**
 * Created by ZHF on 2018/9/10.
 */
public class Main {
    public static char[] reverse(char[] chars) {
        char[] temp = new char[chars.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chars[temp.length - 1 - i];
        }
        return temp;
    }
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(10);
        ArrayList<Integer> res = new ArrayList<>();
        set.add(new Random().nextInt());
        while (set.size() <= 10) {
            set.add(new Random().nextInt());
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            char[] chars = (val + "").toCharArray();
            chars = reverse(chars);
            String s = "";
            for (int i = 0; i < chars.length; i++) {
                s += chars[i];
            }
            res.add(Integer.valueOf(s));
        }
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
}
