class Solution
{
	int getLevelDiff(Node root)
	{
	    //code here
	    int sum=0;
	    List<List<Integer>> ans=new ArrayList();
	    Queue<Node> q=new LinkedList();
	    q.offer(root);
	    
	    while(!q.isEmpty())
	    {
	        List<Integer> list=new ArrayList();
	        int n=q.size();
	        for(int i=0;i<n;i++)
	        {
	            Node nd=q.poll();
	            list.add(nd.data);
	            if(nd.left!=null)
	            q.offer(nd.left);
	            if(nd.right!=null)
	            q.offer(nd.right);
	        }
	        ans.add(list);
	    }
	    int n=ans.size();
	    for(int i=0;i<n;i++)
	    {
	        int temp=0;
	        for(int x: ans.get(i))
	        {
	            temp+=x;
	        }
	        if(i%2==0)
	        sum+=temp;
	        else
	        sum-=temp;
	    }
	    return sum;
	}
}
