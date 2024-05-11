class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        int[] rank=new int[n+1];

        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
        int i=0;
        for(;i<n;i++)
        {
            int[] temp=edges[i];
            int u=temp[0];
            int v=temp[1];

            int x=getParent(u,parent);
            int y=getParent(v,parent);

            if(x==y)
            break;
            else
            {
                union(parent,rank,x,y);
            }
        }
        return edges[i];
        
    }
    private int getParent(int i,int[] parent)
    {
        if(parent[i]==i)
        {
            return parent[i];
        }
        return parent[i]=getParent(parent[i],parent);
    }

    private void union(int[] parent,int[] rank,int x,int y)
    {
        if(x<y)
        {
            parent[x]=y;
            rank[x]+=rank[y];
        }
        else
        {
            parent[y]=x;
            rank[y]+=rank[x]; 
        }
    }
}