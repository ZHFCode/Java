package kuaishou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/25.
 */
public class Main {
    static class Node{
        public int a;
        public int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        while (N > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            list.add(new Node(a, b));
            N--;
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o2.a > o1.a && o2.b > o1.b) {
                    return 1;
                } else if (o2.a == o1.a && o2.b == o1.b) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (Node node:list
             ) {
            System.out.println(node.a + " " + node.b);
        }
        scanner.close();
    }
}
