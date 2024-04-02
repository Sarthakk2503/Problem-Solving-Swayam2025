 if(root==null)
        return new ArrayList<>();

        Queue<TreeNode> q=new LinkedList();
        List<List<Integer>> list=new ArrayList();
        List<Integer> ans=new ArrayList();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            List<Integer> temp=new ArrayList();
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode node=q.poll();
                temp.add(node.data);

                if(node.left!=null)
                q.offer(node.left);
                if(node.right!=null)
                q.offer(node.right);
            }
            list.add(temp);
        }
        for(List<Integer> l:list)
        {
            ans.add(l.get(0));
        }
        for(int i=list.size()-1;i>0;i--)
        {
            List<Integer> temp=list.get(i);
            if(temp.size()>1)
            ans.add(temp.get(temp.size()-1));
        }
        
        return ans;