package Binary_Trees;

public class DiameterofBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int l1 = getLen(root.left);
        int l2 = getLen(root.right);
        max = Math.max(l1+l2, max);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    private int getLen(TreeNode root){
        if(root == null) return 0;
        int l1=getLen(root.left);
        int l2=getLen(root.right);
        return 1+Math.max(l1,l2);
    }
}
