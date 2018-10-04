package aiqiyi;

import java.util.*;

/**
 * Created by ZHF on 2018/9/15.
 */
public class Main1 {
    static class Node{
        public int zhonglei;
        public int zonggeshu;

        Node(int zhonglei, int zonggeshu) {
            this.zhonglei = zhonglei;
            this.zonggeshu = zonggeshu;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();  //M天
        int P = scanner.nextInt();  //目标

        HashMap<Integer, Integer> map1 = new HashMap<>(); //key 种类，value 个数
        for (int i = 0; i < N; i++) {
            map1.put(i + 1, 0);
        }
        for (int i = 0; i < N; i++) {
            int key = i + 1;
            int val = scanner.nextInt();
            map1.put(key, val);
        }
        while (M > 0) {
            String s = scanner.next();
            int num = scanner.nextInt();
            if (s.equals("A")) {
                int val = map1.get(num);
                map1.put(num, val + 1);
            }
            if (s.equals("B")) {
                int val = map1.get(num);
                if (val - 1 <= 0) {
                    map1.put(num, 0);
                } else {
                    map1.put(num, map1.get(num) - 1);
                }
            }
            M--;
        }
        ArrayList<Node> arrayList = new ArrayList<>();
        Iterator<Integer> iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int val = map1.get(key);
            arrayList.add(new Node(key, val));
        }
        Collections.sort(arrayList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.zonggeshu - o1.zonggeshu;
            }
        });

        int index = 1;
        for (Node node:arrayList
             ) {
            if (node.zhonglei != P) {
                index++;
            } else {
                break;
            }
        }
        System.out.println(index);
    }
}
