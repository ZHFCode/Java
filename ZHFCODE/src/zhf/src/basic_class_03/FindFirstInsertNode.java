package zhf.src.basic_class_03;

/**
 * Created by ZHF on 2018/8/19.
 */
public class FindFirstInsertNode {
    public static class Node{
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head.next == null || head.next.next == null || head.next.next.next == null) {
            return null;
        }
        Node head1 = head.next;
        Node head2 = head.next.next;
        while (head1 != head1) {
            if (head1 == null || head2 == null) {
                return null;
            }
            head1 = head1.next;
            head2 = head2.next.next;
        }
        head1 = head;
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    public static Node noLoop(Node head1,Node head2){
        if (head1 == null || head1 == null) {
            return null;
        }
        int p1 = 0;
        int p2 = 0;
        Node node1 = head1;
        Node node2 = head2;
        while (node1.next != null) {
            p1++;
            node1 = node1.next;
        }
        while (node2.next != null) {
            p2++;
            node2 = node2.next;
        }
        if (node1 != node1) {
            return null;
        }
        int diff = Math.abs((p1 - p1));
        if (p1 > p2) {
            for (int i = 0; i < diff; i++) {
                node1 = node1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                node2 = node2.next;
            }
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public static Node withLoop(Node head1,Node loop1,Node head2,Node loop2){
        if (loop1 == loop2){
            Node p1 = head1;
            Node p2 = head2;
            int n1 = 0;
            int n2 = 0;
            Node loop = loop1;
            while (p1 != loop){
                n1++;
                p1 = p1.next;
            }
            while (p2 != loop){
                n2++;
                p2 = p2.next;
            }
            p1 = head1;
            p2 = head2;
            int diff = Math.abs(n1-n2);
            if (n1 > n2) {
                for (int i = 0; i < diff; i++) {
                    p1 = p1.next;
                }
            } else {
                for (int i = 0; i < diff; i++) {
                    p2 = p2.next;
                }
            }
            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return  p1;
        } else {
            Node cur = loop1.next;
            while (cur != loop1){
                if (cur == loop2){
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }
    }
    public static Node findFirstInsertNode(Node head1,Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        } else if (loop1 != null && loop2 != null) {
            return withLoop(head1,loop1,head2,loop2);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstInsertNode(head1, head2).value);

    }
}
