public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        List<Integer> ans=new ArrayList();
        helper(root,ans,1);
        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void helper(TreeNode<Integer> root,List<Integer> ans,int level)
    {
        if(root==null)
        return;

        if(ans.size()<level)
        {
            ans.add(root.data);
        }

        helper(root.left,ans,level+1);
        helper(root.right,ans,level+1);
    }
}