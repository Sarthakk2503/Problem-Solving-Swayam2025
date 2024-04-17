public class Solution {
    int ans=0;
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<Integer>();
        }
        int root=-1;
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i)==-1)
            {
                root=i;
                continue;
            }
            adj[A.get(i)].add(i);
        }
        findDistance(adj,root);
        
        return ans;
    }
    public int findDistance(List<Integer>[] adj,int root)
    {
        int x=0;
        for(int i:adj[root])
        {
            int temp=findDistance(adj,i);
            ans=Math.max(ans,x+temp);
            x=Math.max(x,temp);
        }
        return x+1;
    }
}
