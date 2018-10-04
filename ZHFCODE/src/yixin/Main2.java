package yixin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ZHF on 2018/9/19.
 */
public class Main2 {
    static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void preOder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.value + " ");
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
    }

    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.add(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

    public static void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.add(node);
            if (node.left != null) {
                stack1.add(node.left);
            }
            if (node.right != null) {
                stack1.add(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value+" ");
        }
    }

    public static void levelOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
