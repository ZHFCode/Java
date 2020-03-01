package zhf.src.basic_class_04;

/**
 * Created by ZHF on 2018/8/20.
 */
/*
要求时间复杂度小于O（n）
不能用遍历，遍历的话相当于O（n）的时间复杂度
 */
public class CompletedBinaryTreeNodeNum {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value){
            this.value = value;
        }
    }
    public static int numNode(TreeNode head){
        if (head == null) {
            return 0;
        }
        return numNode(head);
    }
    public static int numNode(TreeNode head,int level,int h) {
        if (level == h) {
            return 1;
        }
        if (h == maxDepth(head, level) + 1) {
            return (1 << (h - level) + numNode(head.right, level + 1, h));
        } else {
            return (1 << (h - level) + numNode(head.left, level + 1, h));
        }
    }
    public static int maxDepth(TreeNode head,int level){
        while (head.left != null){
            level++;
            head = head.left;
        }
        return level-1;
    }
}
