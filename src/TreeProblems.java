import java.util.Stack;

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


    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;

        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            count++;
            if (count==k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // DART SOLUTION
//        if(inorder.isEmpty || preorder.isEmpty)  return null;
//        TreeNode? root = TreeNode(preorder[0]);
//        int mid = inorder.indexOf(preorder[0]);
//        root.left = buildTree(preorder.sublist(1, mid+1), inorder.sublist(0, mid));
//        root.right = buildTree(preorder.sublist(mid+1, preorder.length), inorder.sublist(mid+1, inorder.length));
//        return root;
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
