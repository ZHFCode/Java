package zhf.src.basic_class_04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ZHF on 2018/8/19.
 */
public class OrderBinaryTree {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static void preOrderUnRecur(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    public static void inOrderUnRecur(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head!=null){
                if (head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
            System.out.println();
        }
    }
    public static void posOrderUnRecur(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null){
                    stack1.push(head.left);
                }
                if (head.right != null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value);
            }
        }
    }


}
