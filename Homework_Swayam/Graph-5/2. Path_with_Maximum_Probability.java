class pair{
    int node;
    double prob;
    pair(int node,double prob)
    {
        this.node=node;
        this.prob=prob;
    }
}
class Solution {
    double ans=0.0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<pair>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        adj[i]=new ArrayList<pair>();
        for(int i=0;i<edges.length;i++)
        {
            adj[edges[i][0]].add(new pair(edges[i][1],succProb[i]));
            adj[edges[i][1]].add(new pair(edges[i][0],succProb[i]));
        }
        boolean[] visited=new boolean[n];
        PriorityQueue<pair> pq=new PriorityQueue<pair>((a,b)-> Double.compare(b.prob,a.prob));
        pq.add(new pair(start_node,1));
        return bfs(adj,visited,start_node,end_node,pq);
    }
    public double bfs(List<pair>[] adj,boolean[] visited,int st,int end,PriorityQueue<pair> pq)
    {
        while(pq.size()!=0)
        {
            pair temp=pq.poll();
            visited[temp.node]=true;
            if(temp.node==end)
            return temp.prob;

            for(pair i:adj[temp.node])
            {
                if(!visited[i.node])
                {
                    pq.add(new pair(i.node,temp.prob*i.prob));
                }
            }
        }
        return 0.0;
    }
}