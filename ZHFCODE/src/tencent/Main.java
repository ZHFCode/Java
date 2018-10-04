package tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/18.
 */
public class Main {
    static class Node{
        private int k;

        public Node(int k) {
            this.k = k;
        }
        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return this.k == node.k;
        }
    }
    public static void main(String[] args) {
        Map<Node, Integer> map = new HashMap<>();
        Node a = new Node(1);
//        Node b = new Node(1);
        map.put(a, 1);
        map.put(a, 2);
        System.out.println(map.size());
    }
}
