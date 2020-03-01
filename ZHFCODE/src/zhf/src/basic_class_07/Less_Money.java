package zhf.src.basic_class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ZHF on 2018/8/23.
 */
public class Less_Money {
    public static int lessMoney(int[] arr) {
        if (arr == null) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            int cur = priorityQueue.poll()+priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }
        return sum;
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };
        PriorityQueue<Integer> mQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            mQ1.add(arrForHeap[i]);
        }
        while (!mQ1.isEmpty()) {
            System.out.print(mQ1.poll()+" ");
        }
        System.out.println();

        PriorityQueue<Integer> minQ = new PriorityQueue<>(new MinHeapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ.add(arrForHeap[i]);
        }
        while (!minQ.isEmpty()) {
            System.out.print(minQ.poll()+" ");
        }
        System.out.println();


        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxHeapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll()+" ");
        }

        System.out.println(lessMoney(arrForHeap));
    }
}
