import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/4.
 */
public class Main {
    public static class Node{
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int setSize = Integer.valueOf(scanner.nextLine());
        int[] x = new int[setSize];
        int[] y = new int[setSize];
        int index = 0;
        ArrayList<Node> data = new ArrayList<>();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] xy = s.split(" ");
            Node node = new Node(Integer.valueOf(xy[0]), Integer.valueOf(xy[1]));
        }
        int numTotal_0 = 0;
        int numTotal_1 = 0;
        for (Node node:data
             ) {
            if (node.y == 0) {
                numTotal_0++;
            }
            if (node.y == 1) {
                numTotal_1++;
            }
        }
        double totalP0 = numTotal_0 / data.size();
        double totalP1 = numTotal_1 / data.size();
        double HD = -totalP0 * Math.log(totalP0) - totalP1 * Math.log(totalP1);

        HashSet<Integer> set = new HashSet<>();
        for (Node n :
                data) {
            set.add(n.x);
        }

        double totalExt = 0;
        Iterator<Integer> iterator = set.iterator();
        ArrayList<ArrayList<Node>> context = new ArrayList<>();
        while (iterator.hasNext()) {
            int x_i = iterator.next();
            ArrayList<Node> tmp = new ArrayList<>();
            for (Node node:
                 data) {
                if (node.x == x_i) {
                    tmp.add(node);
                }
            }
            double p_xi = tmp.size() / data.size();

            int tempNum0 = 0;
            int tempNum1 = 0;
            for (Node node:tmp
                 ) {
                if (node.y == 0) {
                    tempNum0++;
                }
                if (node.y == 1) {
                    tempNum1++;
                }
            }
            double HDxi = -(double) (tempNum0 / tmp.size()) * Math.log((tempNum0 / tmp.size())) - (double) (tempNum1 / tmp.size()) * Math.log(tempNum1 / tmp.size());
            totalExt = totalExt + p_xi * HDxi;
        }
        System.out.println(HD - totalExt);
    }
}
