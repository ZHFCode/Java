package basic_class_04;

/**
 * Created by ZHF on 2018/8/19.
 */
public class GetNextNode {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int value;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode getNextNode(TreeNode head){
        if (head==null){
            return null;
        }
        if (head.right != null){
            head = head.right;
            while (head.left != null) {
                head = head.left;
            }
            return head;
        } else {
            TreeNode pParent = head.parent;
            while (pParent!=null && pParent.left != head){
                head = pParent;
                pParent = head.parent;
            }
            return pParent;
        }
    }
}
