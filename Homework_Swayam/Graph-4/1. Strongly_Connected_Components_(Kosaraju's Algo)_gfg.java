class Solution
{

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        List<Integer>[] adjj=new ArrayList[V];
        List<Integer>[] rev_adj=new ArrayList[V];
        
        for(int i=0;i<V;i++)
        {
            adjj[i]=new ArrayList<Integer>();
            rev_adj[i]=new ArrayList<Integer>();
        }
        
        
        for(int i=0;i<V;i++)
        {
            for(int l:adj.get(i))
            {
                adjj[i].add(l);
                rev_adj[l].add(i);
            }
            
        }
        
        boolean[] visited=new boolean[V];
        Stack<Integer> st=new Stack();
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            dfs(i,st,visited,adjj);
        }
        
        visited=new boolean[V];
        int count=0;
        while(st.size()>0)
        {
            int node=st.pop();
            
            if(!visited[node])
            {
                count++;
                dfsFindSCC(node,rev_adj,visited);
            }
        }
        return count;
    }
    public void dfs(int node,Stack<Integer> st,boolean[] visited,List<Integer>[] adj)
    {
        visited[node]=true;
        for(int neighbor:adj[node])
        {
            if(!visited[neighbor])
            dfs(neighbor,st,visited,adj);
        }
        st.push(node);
    }
    public void dfsFindSCC(int node,List<Integer>[] revadj,boolean[] visited)
    {
        visited[node]=true;
        for(int neighbor:revadj[node])
        {
            if(!visited[neighbor])
            {
                dfsFindSCC(neighbor,revadj,visited);
            }
        }
    }
}
