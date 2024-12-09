//package Binary_Trees;
//
//public class SameTree {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (q == null && p == null) return  true;
//        if (q != null && p != null && p.val == q.val) {
//            return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
//        }
//        return false;
//    }
//
//    private boolean chechNodes(TreeNode p,TreeNode  q){
//        if (p.val != q.val) return false;
//
//        boolean l1=chechNodes(q.left, p.left);
//        boolean l2=chechNodes(q.right, p.right);
//        return l1 || l2 ;
//    }
//
//    private boolean getLen(TreeNode root){
//        if(root == null) return 0;
//        int l1=getLen(root.left);
//        int l2=getLen(root.right);
//        return 1+Math.max(l1,l2);
//    }
//
//
//}
