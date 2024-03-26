class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
        return new ArrayList();

        List<List<Integer>> ans=new ArrayList();
        Queue<TreeNode> q=new LinkedList();
        q.offer(root);

        while(!q.isEmpty())
        {
            List<Integer> list=new ArrayList();
            int n=q.size();
            
            for(int i=0;i<n;i++)
            {
                TreeNode node=q.poll();
                list.add(node.val);
                if(node.left!=null)
                q.offer(node.left);
                if(node.right!=null)
                q.offer(node.right);
            }
            ans.add(list);
        }
        return ans;
    }
}