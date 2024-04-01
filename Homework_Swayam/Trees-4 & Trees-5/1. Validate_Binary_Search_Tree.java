class Solution {
    boolean flag=true;
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return flag;
    }
    public void inOrder(TreeNode root)
    {
        if(root==null)
        return;
        
        inOrder(root.left);
        if(prev==null)
        prev=root;
        else if(root.val<=prev.val)
        {
            flag=false;
        }
        prev=root;
        inOrder(root.right);
    }
}