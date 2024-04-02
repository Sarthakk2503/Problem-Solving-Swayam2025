class Solution {
    TreeNode prev=null;
    TreeNode element1=null,element2=null;
    boolean pair1Found=false;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp=element1.val;
        element1.val=element2.val;
        element2.val=temp;
    }
    public void helper(TreeNode root)
    {
        if(root==null)
        return;

        helper(root.left);
        if(prev!=null && root.val<prev.val)
        {
            if(element1==null)
            element1=prev;
            
            element2=root;
            pair1Found=true;
        }
        else if(prev!=null && root.val<prev.val)
        {
            element2=root;
        }
        prev=root;
        helper(root.right);
    }
}