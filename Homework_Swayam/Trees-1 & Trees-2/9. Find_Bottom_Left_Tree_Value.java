class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList();
        List<List<Integer>> ans=new ArrayList();
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> temp=new ArrayList();
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left==null)
                q.offer(node.left);
                if(node.right!=null)
                q.offer(node.right);
            }
            ans.add(temp);
        }
        return ans.get(ans.size()-1).get(0);
    }
}