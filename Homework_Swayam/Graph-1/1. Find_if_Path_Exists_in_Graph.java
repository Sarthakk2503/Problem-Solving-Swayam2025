class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj=new ArrayList[n];
        for(int[] ar:edges)
        {
            if(adj[ar[0]]==null)
            {
                adj[ar[0]]=new ArrayList<Integer>();
            }
            if(adj[ar[1]]==null)
            {
                adj[ar[1]]=new ArrayList<Integer>();
            }
            adj[ar[0]].add(ar[1]);
            adj[ar[1]].add(ar[0]);
        }
        boolean[] visited=new boolean[n];
        if(bfs(adj,visited,source,destination))
        return true;
        return false;
    }
    public boolean bfs(List<Integer>[] adj,boolean[] visited,int s,int d)
    {
        Queue<Integer> q=new LinkedList();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty())
        {
            int temp=q.poll();
            if(temp==d)
            return true;
            List<Integer> l=adj[temp];
            for(int i:l)
            {
                if(!visited[i])
                {
                    q.offer(i);
                    visited[i]=true;
                }
                
            }
        }
        return false;
    }
}