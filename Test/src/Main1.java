import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/4.
 */
public class Main1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
        String s1 = "1 1 1 2 3 4 1 2 3 4 1 3 4 1 2 3 3 1 2 3 1 2 3 1 3 1";
        String s2 = "2 2 2 2 3 4 4 2 2 1 2 4 3 2 2 1 3 4 4 2 4 3";

        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        HashMap<String, Integer> pSet = new HashMap<>();
        HashMap<String, Integer> ySet = new HashMap<>();
        for (int i = 0; i < str1.length; i++) {
            if (!pSet.containsKey(str1[i])) {
                pSet.put(str1[i], 1);
            } else {
                pSet.put(str1[i], pSet.get(str1[i]) + 1);
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if (!ySet.containsKey(str2[i])) {
                ySet.put(str2[i], 1);
            } else {
                ySet.put(str2[i], ySet.get(str2[i]) + 1);
            }
        }
        int n1 = str1.length;
        int n2 = str2.length;

        double[] px = new double[pSet.size()];
        double[] qx = new double[ySet.size()];


        Iterator<String> iterator1 = pSet.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = iterator1.next();
            int key_num = Integer.valueOf(key);
            int val = pSet.get(key);
            double pro = (double) val / n1;
            px[key_num-1] = pro;
        }
        Iterator<String> iterator2 = ySet.keySet().iterator();
        while (iterator2.hasNext()) {
            String key = iterator2.next();
            int key_num = Integer.valueOf(key);
            int val = ySet.get(key);
            double pro = (double) val / n2;
            qx[key_num - 1] = pro;
        }
        double res = 0;
        for (int i = 0; i < qx.length; i++) {
            res += px[i] * Math.log(px[i] / qx[i]);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(res));
    }
}
