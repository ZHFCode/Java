package basic_class_03;

import com.sun.org.apache.bcel.internal.generic.NOP;

/**
 * Created by ZHF on 2018/8/18.
 */
public class IsPalindromeList {
    public static class Node{
        public Node next;
        public int val;
        public Node(int val){
            this.val = val;
        }
    }
    public static boolean isPalindromeList(Node head){
        if (head == null) {
            return false;
        }
        boolean res = true;
        Node pSlow = head;
        Node pFast = head;

        Node pLeft = null;
        Node pRight = null;
        //先找到中间的链表节点
        while (pSlow.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        pFast = pSlow.next;
        pSlow.next = null;
        pLeft = pSlow;


        Node pNext = null;
        while (pFast != null) {
            pNext = pFast.next;
            pFast.next = pSlow;
            pSlow = pFast;
            pFast = pNext;
        }
        pRight = pSlow;
        while (head != null && pSlow != null) {
            if (head.val != pSlow.val) {
                res = false;
                break;
            }
            head = head.next;
            pSlow = pSlow.next;
        }
        pNext = null;
        pFast = null;
        while (pRight != null) {
            pNext = pRight.next;
            pRight.next = pFast;
            pFast = pRight;
            pRight = pNext;
        }
        pLeft.next = pFast;
        return res;
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
//        head.next.next.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindromeList(head) + " | ");
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
