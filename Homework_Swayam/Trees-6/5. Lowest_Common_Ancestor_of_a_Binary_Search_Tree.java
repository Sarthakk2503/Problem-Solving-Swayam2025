class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }
    TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
        return null;

        if(root.val>p.val && root.val>q.val)
        return helper(root.left,p,q);
        else if(root.val<p.val && root.val<q.val)
        return helper(root.right,p,q);
        else
        {
            return root;
        }
    }
}