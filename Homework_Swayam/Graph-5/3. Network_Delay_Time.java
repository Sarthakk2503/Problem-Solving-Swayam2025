class pair{
    int node;
    int time;
    pair(int node,int time)
    {
        this.node=node;
        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<pair>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        adj[i]=new ArrayList<pair>();

        for(int i=0;i<times.length;i++)
        {
            adj[times[i][0]].add(new pair(times[i][1],times[i][2]));
        }
        boolean[] visited=new boolean[n+1];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.time-b.time;
        });
        pq.add(new pair(k,0));
        return bfs(adj,visited,pq,n);
    }
    public int bfs(List<pair>[] adj,boolean[] visited,PriorityQueue<pair> pq,int n)
    {
        int ans=0;
        int nodeCount=0;
        while(pq.size()!=0)
        {
            pair temp=pq.poll();
            int currNode=temp.node;
            int currTime=temp.time;

            if(visited[currNode])
            continue;
            visited[currNode]=true;
            ans=currTime;
            nodeCount++;

            for(pair i: adj[currNode])
            {
                if(!visited[i.node])
                {
                    pq.add(new pair(i.node,i.time+currTime));
                }
            }
        }
        if(nodeCount==n)
        return ans;
        else
        return -1;
    }
}