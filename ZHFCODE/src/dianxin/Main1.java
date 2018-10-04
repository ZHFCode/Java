package dianxin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ZHF on 2018/9/10.
 */

public class Main1{
    static class Node{
        private int a;
        private int b;
        private int c;
        private int d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args) {
        ArrayList<Node> arrayList = new ArrayList<>();
        int a, b, c, d;
        for (a = 0; a < 10; a++) {
            for (b = 0; b < 10; b++) {
                for ( c = 0; c < 10; c++) {
                    for (d = 0; d < 10; d++) {
                        int t1 = a * 1000 + b * 100 + c * 10 + d;
                        int t2 = b * 1000 + c * 100 + d * 10 + a;
                        if ((t1 + t2) == 8888) {
                            arrayList.add(new Node(a, b, c, d));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });
        for (Node node:arrayList
             ) {
            System.out.println(node.a + " " + node.b + " " + node.c + " " + node.d);
        }
    }
}