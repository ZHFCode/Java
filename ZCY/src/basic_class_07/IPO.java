package basic_class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ZHF on 2018/8/25.
 */
public class IPO {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p-o1.p;
        }
    }

    public static int findMaximizedCapital(int k,int w,int[] cost,int[] profit) {
        Node[] project = new Node[cost.length];
        for (int i = 0; i < project.length; i++) {
            project[i] = new Node(profit[i],cost[i]);
        }
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        for (int j = 0; j < project.length; j++) {
            minCost.add(project[j]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().c <= w) {
                maxProfit.add(minCost.poll());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            Node tmp = maxProfit.poll();
            w += tmp.p;
        }
        return w;
    }

}
