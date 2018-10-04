package jindong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/9/9.
 */
public class Main {
    static class Node {
        private long a;
        private long b;
        private long c;

        public Node(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        while (N > 0) {
            list.add(new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
            N--;
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                Node n1 = list.get(i);
                Node n2 = list.get(j);
                if (n1.a < n2.a && n1.b < n2.b && n1.c < n2.c) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
