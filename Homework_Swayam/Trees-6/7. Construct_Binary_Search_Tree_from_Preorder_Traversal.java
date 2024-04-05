class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    TreeNode helper(int[] preorder,int st,int end)
    {
        if(st>end)
        return null;

        TreeNode root=new TreeNode(preorder[st]);
        int i;
        for(i=st+1;i<=end;i++)
        {
            if(preorder[i]>preorder[st])
            break;
        }
        root.left=helper(preorder,st+1,i-1);
        root.right=helper(preorder,i,end);
        return root;
    }
}