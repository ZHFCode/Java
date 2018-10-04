package xiaohongshu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/15.
 */
public class Main {
    static class Node{
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Node> list = new ArrayList<>();
        String s = scanner.nextLine();
        String[] ss = s.split(" ");

        for (int i = 0; i < ss.length; i++) {
            list.add(new Node(Integer.valueOf(ss[i])));
        }
        Node pHead = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Node n1 = list.get(i - 1);
            Node n2 = list.get(i);
            n1.next = n2;
        }
        list.get(list.size()-1).next = null;
        int k = Integer.valueOf(scanner.nextLine());

        if (k == 1) {
            Node p = list.get(0);
            while (p != null) {
                System.out.print(p.value+" ");
                p = p.next;
            }
        } else if (k < list.size() && k > 1) {
            Node pNext = null;
            Node pPre = null;
            while (k > 0) {
                pNext = pHead.next;
                pHead.next = pPre;
                pPre = pHead;
                pHead = pNext;
                k--;
            }
            Node pStart = pPre;
            Node pTMP = pStart;
            while (pTMP.next != null) {
                pTMP = pTMP.next;
            }
            pTMP.next = pHead;
            while (pStart != null) {
                System.out.print(pStart.value + " ");
                pStart = pStart.next;
            }
        } else {
            Node pPre = null;
            Node pNext = null;
            while (pHead != null) {
                pNext = pHead.next;
                pHead.next = pPre;
                pPre = pHead;
                pHead = pNext;
            }
            Node pR = pPre;
            while (pR != null) {
                System.out.print(pR.value + " ");
                pR = pR.next;
            }
        }
    }
}
