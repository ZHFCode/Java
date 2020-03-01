package zhf.src.basic_class_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ZHF on 2018/8/19.
 */
public class SerializeBinaryTree {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode deSerializeTree(Queue<String> queue){
        String value = queue.poll();
        if (value == null){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = deSerializeTree(queue);
        head.right = deSerializeTree(queue);
        return head;
    }
    public static TreeNode deSerializeTree(String s){
        String[] strings = s.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        return deSerializeTree(queue);
    }
    public static String serializeTree(TreeNode head){
        if (head == null) {
            return "#!";
        }
        String res = head.value+"!";
        res += serializeTree(head.left);
        res += serializeTree(head.right);
        return res;
    }
}
