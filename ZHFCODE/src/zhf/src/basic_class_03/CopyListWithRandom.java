package zhf.src.basic_class_03;

/**
 * Created by ZHF on 2018/8/18.
 */
public class CopyListWithRandom {
    static class Node{
        public Node next;
        public Node random;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }
    public static Node copyListWithRandom(Node head){
        Node pCur = head;
        Node pNext = null;
        while (pCur!=null){
            pNext = pCur.next;
            pCur.next = new Node(pCur.value);
            pCur.next.next = pNext;
            pCur = pNext;
        }
        pCur = head;
        while (pCur!=null){
            if (pCur.random != null){
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }

        //拆解链表
        pCur = head;
        Node pHeadNew = head.next;
        Node pRes = pHeadNew;
        while (pCur != null){
            pCur.next = pCur.next.next;
            if (pHeadNew.next != null){
                pHeadNew = pHeadNew.next.next;
            }
            pCur = pCur.next;
            pHeadNew = pHeadNew.next;
        }
        return pRes;
    }
}
