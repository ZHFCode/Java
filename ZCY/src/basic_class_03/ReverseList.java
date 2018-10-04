package basic_class_03;


/**
 * Created by ZHF on 2018/8/17.
 */
public class ReverseList {
    public class Node{
        public Node next;
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node reverseList(Node head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
