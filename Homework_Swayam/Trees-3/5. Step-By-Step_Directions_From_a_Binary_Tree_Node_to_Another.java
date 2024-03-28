class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();

        helper(root,path1,startValue);
        helper(root,path2,destValue);

        path1.reverse();
        path2.reverse();

        int n=Math.min(path1.length(),path2.length());
        StringBuilder ans=new StringBuilder();

        int i=0;
        for(;i<n;i++)
        {
            if(path1.charAt(i)!=path2.charAt(i))
            break;
        }
        for(int j=i;j<path1.length();j++)
        ans.append("U");

        for(int j=i;j<path2.length();j++)
        ans.append(path2.charAt(j));

        return ans.toString();
    }
    public boolean helper(TreeNode root,StringBuilder sb,int val)
    {
        if(root==null)
        return false;

        if(root.val==val)
        return true;

        if(helper(root.left,sb,val))
        {
            sb.append("L");
            return true;
        }
        if(helper(root.right,sb,val))
        {
            sb.append("R");
            return true;
        }

        return false;
    }
}