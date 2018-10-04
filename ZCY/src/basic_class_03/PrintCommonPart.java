package basic_class_03;

/**
 * Created by ZHF on 2018/8/18.
 * @author ZHF
 */
public class PrintCommonPart {
    public static class Node{
        private Node next;
        private int val;
        public Node(int val){
            this.val = val;
        }
    }
    public static void printCommomPart(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return;
        }
        while (head1!=null && head2!=null){
            if (head1.val == head2.val){
                System.out.print(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }else if (head1.val < head2.val){
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
    }
}
