import java.util.LinkedList;
import java.util.*;
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
        return new TreeNode(0);
    }

    public void bfs(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);

        while (!q.isEmpty()){
            for (int i = 0; i < q.size(); i++) {
                TreeNode cur = q.poll();
                System.out.println(cur.val);
                if (cur.left!=null) q.add(cur.left);
                if (cur.right!=null) q.add(cur.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new  LinkedList<>();
        q.add(root);
        int level = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<q.size();i++){
                TreeNode cur = q.poll();
                arr.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            res.add(arr);
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return  new ArrayList<>();
        Queue<TreeNode> q = new  LinkedList<>();
        q.add(root);
        int level = 0;
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<levelSize;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                arr.add(cur.val);
            }
            res.add(arr.get(arr.size()-1));
        }
        return res;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        targetSum-= root.val;
        if(root.left==null && root.right!=null)
            return targetSum == 0;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
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
