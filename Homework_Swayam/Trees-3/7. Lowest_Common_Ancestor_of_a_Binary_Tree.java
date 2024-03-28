class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        return null;

        if(root==p || root==q)
        return root;

        TreeNode nodeOnLeft=lowestCommonAncestor(root.left,p,q);
        TreeNode nodeOnRight=lowestCommonAncestor(root.right,p,q);

        if(nodeOnLeft!=null && nodeOnRight!=null)
        return root;
        else if(nodeOnLeft!=null)
        return nodeOnLeft;
        else
        return nodeOnRight;
    }
}