class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis=new int[n][n];
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                dis[i][j]=0;
                else
                dis[i][j]=(int)1e9;
            }
        }
        for(int[] arr:edges)
        {
            int x=arr[0];
            int y=arr[1];
            int distance=arr[2];
            dis[x][y]=distance;
            dis[y][x]=distance;
        }
        for(int k=0;k<n;k++)
       {
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
               }
           }
       }
        int size=n;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && dis[i][j]<=distanceThreshold)
                {
                    adj[i].add(j);
                }
                
            }
            if(adj[i].size()<size)
            size=adj[i].size();
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(adj[i].size()==size && i>ans)
            ans=i;
        }
        return ans;
    }
}