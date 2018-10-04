import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ZHF on 2018/9/12.
 */
public class TreeDepth {
    static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static int maxDepthRecur(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = maxDepthRecur(head.left);
        int rightDepth = maxDepthRecur(head.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int maxDepthUnRecur(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count =0;
        int dep = 0;
        int nextCount = 1;
        queue.add(head);
        while (queue.size() > 0) {
            TreeNode tmp = queue.poll();
            count++;
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            if (count == nextCount) {
                count = 0;
                dep++;
                nextCount = queue.size();
            }
        }
        return dep;
    }
}
