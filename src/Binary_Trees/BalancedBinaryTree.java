package Binary_Trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return getLen(root) !=-1;
    }

    private int getLen(TreeNode root){
        if(root == null) return 0;
        int l1=getLen(root.left);
        int l2=getLen(root.right);
        if (l1 ==-1 || l2 ==-1) return -1;
        if (Math.abs(l1 - l2)>2) return -1;
        return 1+Math.max(l1,l2);
    }
}
