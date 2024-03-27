class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList();
        helper(root,ans,"");
        //System.out.println(ans);
        return ans;
    }
    void helper(TreeNode root,List<String> ans,String s)
    {
        if(root==null)
        return;

        s+=root.val+"";
        if(root.left==null && root.right==null)
        ans.add(s);

        s+="->";
        helper(root.left,ans,s);
        helper(root.right,ans,s);
    }
}
