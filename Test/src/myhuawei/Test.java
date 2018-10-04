package myhuawei;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    static class Node{
        String str;
        int count;

        public Node(String str,int count){
            this.str=str;
            this.count=count;
        }
    }
    static class QueueComparator implements Comparator<Node>{
        public int compare(Node o1,Node o2){
            if(o1.count<o2.count)
                return -1;
            else if(o1.count>o2.count)
                return 1;
            else {
                if(o1.str.length()<o2.str.length())
                    return -1;
                if(o1.str.length()>o2.str.length())
                    return 1;
                else
                    return o1.str.compareTo(o2.str);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder temp=new StringBuilder();
        StringBuilder res=new StringBuilder();
        PriorityQueue<Node> queue=new PriorityQueue<>(new QueueComparator());
        int index=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)-'0'>='0' && str.charAt(i)-'0'<='9'){
                index = index*10+(str.charAt(i)-'0');
            }
            else
            {
                if(index>0){
                    queue.add(new Node(temp.toString(),index));
                    temp=new StringBuilder();
                }
                temp.append(str.charAt(i));
                index=0;
            }
        }
        queue.add(new Node(temp.toString(),index));
        while (!queue.isEmpty()){
            Node node=queue.poll();
            int num=node.count;
            String s=node.str;
            while (num!=0){
                res.append(s);
                num--;
            }
        }
        System.out.println(res.toString());
        sc.close();
    }
}
