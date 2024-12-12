public class TreeProblems {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val<val) {
            return searchBST(root.right, val);
        }else if(root.val>val) {
            return searchBST(root.left, val);
        } else {

            return root;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        int cur = root.val;
        if(cur>p.val && cur>q.val) return lowestCommonAncestor( root.left, p, q);
        if(cur<p.val && cur<q.val) return lowestCommonAncestor( root.right, p, q);
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode right = null;
    TreeNode left = null;

    TreeNode(int val){
        this.val = val;
    }
}
