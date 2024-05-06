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
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<pair>> adj=new ArrayList();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<pair>());
        for(int[] arr:edges)
        {
            adj.get(arr[0]).add(new pair(arr[1],arr[2]));
            adj.get(arr[1]).add(new pair(arr[0],arr[2]));
        }
        PriorityQueue<pair> pq=new PriorityQueue<pair>((a,b)->a.time-b.time);
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        pq.offer(new pair(0,0));

        while(!pq.isEmpty())
        {
            pair temp=pq.poll();
            int node=temp.node;
            int time=temp.time;

            if(dis[node]<time)
            continue;

            for(pair p:adj.get(node))
            {
                int no=p.node;
                int t=p.time;
                if(dis[no]>time+t && disappear[no]>time+t)
               {
                    dis[no]=time+t;
                    pq.add(new pair(no,dis[no]));
               }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(dis[i]==Integer.MAX_VALUE)
            dis[i]=-1;
        }
        return dis;
    }
}