package zhf.src.basic_class_03;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ZHF on 2018/9/1.
 */
public class ZigZagBinaryTree {
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static ArrayList<ArrayList<TreeNode>> print(TreeNode pHead) {
        ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();
        if (pHead == null) {
            return res;
        }
        boolean isOdd = true;
        Stack<TreeNode> s1 = new Stack<>(); //装奇数行
        Stack<TreeNode> s2 = new Stack<>();  //装偶数行
        s1.add(pHead);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (isOdd == true) {
                ArrayList<TreeNode> tmp = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        tmp.add(node);
                        System.out.print(node.value);
                        if (node.left != null) {
                            s2.add(node.left);
                        }
                        if (node.right != null) {
                            s2.add(node.right);
                        }
                    }
                }
                if (tmp != null) {
                    res.add(tmp);
                }
                isOdd = !isOdd;
            } else {
                ArrayList<TreeNode> tmp = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    System.out.print(node.value);
                    tmp.add(node);
                    if (node.right != null) {
                        s1.add(node.right);
                    }
                    if (node.left != null) {
                        s1.add(node.left);
                    }
                }
                if (tmp != null) {
                    res.add(tmp);
                }
                isOdd = !isOdd;
            }
        }
        return res;
    }
}
