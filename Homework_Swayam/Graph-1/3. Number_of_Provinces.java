class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<Integer>[] adj=new ArrayList[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adj[i].add(j);
                }
            }
        }
        boolean[] visited=new boolean[isConnected.length];
        int n=isConnected.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(adj,visited,i);
            }
        }
        return count;
    }
    public void dfs(List<Integer>[] adj,boolean[] visited,int source)
    {
        visited[source]=true;
        for(int neighbor:adj[source])
        {
            if(!visited[neighbor])
            {
                dfs(adj,visited,neighbor);
            }
        }
    }
}