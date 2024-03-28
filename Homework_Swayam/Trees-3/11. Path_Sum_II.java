class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList();
        List<Integer> path=new ArrayList();
        helper(root,targetSum,ans,path);
        return ans;
    }
    public void helper(TreeNode root,int sum,List<List<Integer>> ans,List<Integer> path)
    {
        if(root==null)
        return;

        path.add(root.val);
        sum-=root.val;
        if(sum==0 && root.left==null && root.right==null)
        {
            ans.add(new ArrayList<>(path));
        }

        helper(root.left,sum,ans,path);
        helper(root.right,sum,ans,path);
        path.remove(path.size()-1);
    }
}