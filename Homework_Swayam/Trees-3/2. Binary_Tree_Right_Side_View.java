class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList();
        helper(root,ans,1);
        return ans;
    }
    public void helper(TreeNode root,List<Integer> ans,int level)
    {
        if(root==null)
        return;

        if(ans.size()<level)
        ans.add(root.val);

        helper(root.right,ans,level+1);
        helper(root.left,ans,level+1);
    }
}