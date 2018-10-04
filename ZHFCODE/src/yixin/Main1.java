package yixin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/11.
 */
public class Main1 {
    static class Node{
        public int start;
        public int end;
        public Node next;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Node> list = new ArrayList<>();
        while (scanner.hasNext()) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new Node(start, end));
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            nodes.add(node);
            for (int j = 0; j < list.size(); j++) {
                Node nextNode = list.get(j);
                if (node.end <= nextNode.start) {
                    node.next = nextNode;
                    node = nextNode;
                }
            }
        }
        int max = 0;
        for (Node n:nodes
             ) {
            int i = 0;
            while (n != null) {
                n = n.next;
                i++;
            }
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);


    }
}
