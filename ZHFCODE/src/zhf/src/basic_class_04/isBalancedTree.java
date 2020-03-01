package zhf.src.basic_class_04;

/**
 * Created by ZHF on 2018/8/19.
 * 是否是平衡二叉树的定义是任何一个节点的左子树和右子树的高度差我不超过1
 */
public class isBalancedTree {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value){
            this.value = value;
        }
    }
    public static class ReturnData{
        public boolean isBalance;
        public int height;
        public ReturnData(boolean isBalance,int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    public static boolean isBalance(TreeNode head) {
        return process(head).isBalance;
    }

    public static ReturnData process(TreeNode head) {
        if (head == null) {
            return new ReturnData(true,0);
        }
        ReturnData left = process(head.left);
        if (!left.isBalance) {
            return new ReturnData(false,0);
        }
        ReturnData right = process(head.right);
        if (!right.isBalance) {
            return new ReturnData(false,0);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new ReturnData(false,0);
        }
        return new ReturnData(true, Math.max(left.height, right.height) + 1);
    }
}
