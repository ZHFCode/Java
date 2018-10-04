package myhuawei;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.count<o2.count) return -1;
                else if(o1.count>o2.count) return 1;
                else{
                    if(o1.str.length()<o2.str.length()) return -1;
                    else if(o1.str.length()>o2.str.length()) return 1;
                    else return o1.str.compareTo(o2.str);
                }
            }
        });
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + (s.charAt(i) - '0');
            }else{
                if(count>0){
                    pq.add(new Node(tmp.toString(),count));
                    tmp = new StringBuilder();
                }
                tmp.append(s.charAt(i));
                count = 0;
            }
        }
        pq.add(new Node(tmp.toString(),count));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int x = node.count;
            while(x>0){
                x--;
                res.append(node.str);
            }
        }
        System.out.println(res.toString());
        sc.close();
    }

    static class Node{
        String str;
        int count;
        public Node(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
}