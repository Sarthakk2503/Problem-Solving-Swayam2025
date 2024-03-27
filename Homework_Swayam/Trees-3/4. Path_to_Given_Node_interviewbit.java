public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans=new ArrayList();
        helper(A,B,ans);
        ArrayList<Integer> temp=new ArrayList();
        for(int i=0;i<ans.size();i++)
        {
            temp.add(ans.get(ans.size()-1-i));
        }
        return temp;
    }
    public boolean helper(TreeNode root,int B,ArrayList<Integer> ans)
    {
        if(root==null)
        return false;
        
        if(root.val==B || helper(root.left,B,ans) || helper(root.right,B,ans))
        {
            ans.add(root.val);
            return true;
        }
        return false;
    }
}