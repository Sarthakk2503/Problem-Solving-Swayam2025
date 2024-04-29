class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]!=-1)
            continue;

            boolean check=bipartiteCheck(i,graph,color,0);
            if(check==false)
            return false;
        }
        return true;
    }
    public boolean bipartiteCheck(int node,int[][] adj,int[] color,int col)
    {
        color[node]=col;
        for(int j:adj[node])
        {
            if(color[j]==-1)
            {
                if(bipartiteCheck(j,adj,color,1^col)==false)
                return false;
            }
            else if(color[j]==color[node])
            return false;
        }
        return true;
    }
    
}