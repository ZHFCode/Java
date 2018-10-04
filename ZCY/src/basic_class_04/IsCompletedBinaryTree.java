package basic_class_04;

import java.util.LinkedList;
import java.util.Queue;
/*
    是否为完全二叉树就层序遍历一个二叉树的节点
 */
/**
 * Created by ZHF on 2018/8/20.
 */
public class IsCompletedBinaryTree {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value){
            this.value = value;
        }
    }

    public static boolean isCompletedBinaryTree(TreeNode head){
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeft = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if ((head.left == null && head.right != null) || (isLeft && (head.right != null || head.left != null))) {
                return false;
            }
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
            if (head.right == null && head.left == null) {
                isLeft = true;
            }
        }
        return true;
    }
}
