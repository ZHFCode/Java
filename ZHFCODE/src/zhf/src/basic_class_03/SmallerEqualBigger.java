package zhf.src.basic_class_03;

/**
 * Created by ZHF on 2018/8/18.
 * @author ZHF
 */
public class SmallerEqualBigger {
    public static class Node{
        public Node next;
        public int val;
        public Node(int val){
            this.val = val;
        }
    }
    public static Node smallEqualBiggerTwo(Node head,int num){
        if (head == null){
            return head;
        }
        int index = 0;
        Node p = head;
        while (p!=null){
            index++;
            p = p.next;
        }
        Node[] arrNode = new Node[index];
        p = head;
        for (int i=0;i<arrNode.length;i++){
            arrNode[i] = p;
            p = p.next;
        }
        nodePartion(arrNode,num);
        for (index = 1;index != arrNode.length;index++){
            arrNode[index-1].next = arrNode[index];
        }
        arrNode[index-1].next = null;
        return  arrNode[0];
    }
    public static void swap(Node[] arr,int i,int j){
        Node t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void nodePartion(Node[] arr,int num){
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur != more){
            if (arr[cur].val < num){
                swap(arr,less+1,cur);
                less++;
                cur++;
            } else if (arr[cur].val > num){
                swap(arr,more-1,cur);
                more--;
            } else {
                cur++;
            }
        }
    }




    public static Node smallEqualBigger(Node head,int num){
        if (head == null){
            return head;
        }
        Node lessHead = null;
        Node lessTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node moreHead = null;
        Node moreTail = null;

        Node pNext = null;
        while (head !=null){
            pNext = head.next;
            head.next = null;
            if (head.val < num){
                if (lessHead == null){
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else if (head.val == num){
                if (equalHead == null){
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (moreHead == null){
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }
            head = pNext;
        }

        //完成拆解

        if (lessTail != null){
            lessTail.next = equalHead;
            equalTail = equalTail == null ? lessTail : equalTail;
        }
        if (equalTail != null){
            equalTail.next = moreHead;
        }
        /*
        if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// all reconnect
		if (eT != null) {
			eT.next = bH;
		}
         */

        return lessHead = lessHead != null ? lessHead : equalHead != null ? equalHead : moreHead;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = smallEqualBigger(head1,5);
        printLinkedList(head1);

    }
}
