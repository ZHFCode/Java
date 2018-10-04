package zhf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/8/27.
 */
public class UnionFindTouTiao1 {

    public static class Node{
        private HashSet<Integer> friends;
        public Node() {
            friends = new HashSet<>();
        }
    }

    public static HashMap<Node,Node> fatherMap;
    public static HashMap<Node,Integer> sizeMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (0 < N || N > 100000) {
            return;
        }

        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        Node[] nodes = new Node[N + 1];
        //1.初始化并查集完成；
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node();
            fatherMap.put(nodes[i],nodes[i]);
            sizeMap.put(nodes[i], 1);
            int tmp = 0;
            while ((tmp = scanner.nextInt()) != 0) {
                nodes[i].friends.add(tmp);
            }
            for (Iterator<Integer> iterator = nodes[i].friends.iterator();iterator.hasNext();) {
                Integer friend = iterator.next();
                if (!isSameSet(nodes[i], nodes[friend])) {
                    union(nodes[i], nodes[friend]);
                    N--;
                }
            }
        }
    }

    public static boolean isSameSet(Node node1, Node node2) {
        return findHead(node1) == findHead(node2);
    }

    public static Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            findHead(father);
        }
        return father;
    }

    public static void union(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        Node head1 = findHead(node1);
        Node head2 = findHead(node2);
        int size1 = sizeMap.get(head1);
        int size2 = sizeMap.get(head2);
        if (head1 != head2) {
            if (size1 <= size2) {
                fatherMap.put(head1, head2);
                sizeMap.put(head2, sizeMap.get(head1) + sizeMap.get(head2));
            } else {
                fatherMap.put(head2, head1);
                sizeMap.put(head1, sizeMap.get(head1) + sizeMap.get(head2));
            }
        }
    }
}
