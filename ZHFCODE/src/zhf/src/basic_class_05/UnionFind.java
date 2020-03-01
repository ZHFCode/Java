package zhf.src.basic_class_05;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ZHF on 2018/8/23.
 */
public class UnionFind {
    public static class Node {
        // whatever you need
    }
    private HashMap<Node,Node> fatherMap;
    private HashMap<Node,Integer> sizeMap;
    private void makeSet(List<Node> list){
        for (Node node:list) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }
    public UnionFind(List<Node> list) {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        makeSet(list);
    }

    private Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public boolean isSameSet(Node node1, Node node2) {
        return fatherMap.get(node1) == fatherMap.get(node2);
    }

    public void union(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        Node head1 = findHead(node1);
        Node head2 = findHead(node2);
        if (head1 != head2) {
            int size1 = sizeMap.get(head1);
            int size2 = sizeMap.get(head2);
            if (size1 > size2) {
                fatherMap.put(head2, head1);
                sizeMap.put(head1, sizeMap.get(head1) + sizeMap.get(head2));
            } else {
                fatherMap.put(head1, head2);
                sizeMap.put(head2,sizeMap.get(head2)+sizeMap.get(head1));
            }
        }
    }

}
