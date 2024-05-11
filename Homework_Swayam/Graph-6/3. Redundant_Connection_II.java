class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[]parent=new int[edges.length+1];
        int[]rank=new int[edges.length+1];

        int[] indegree=new int[edges.length+1];    
        Arrays.fill(indegree,-1);
        
        int a=-1;
        int b=-1;
        
        for(int i=0;i<edges.length;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            
            if(indegree[y]==-1)
            {
                indegree[y]=i;
            }
            else
            {
                a=i;                        
                b=indegree[y];
                break;
            }
        }
        
        for(int i=0;i<parent.length;i++)
        parent[i]=i;
        
        for(int i=0;i<edges.length;i++)
        {
            if(i==a)
            continue;
            
            int[] temp=edges[i];
            boolean flag=union(parent,rank,temp[0],temp[1]);
            if(flag)
            {
                if(a==-1)
                {         
                    return temp;
                }
                else
                {
                    return edges[b]; 
                }
            }
        }
        
        return edges[a];
    }
    
    public int getParent(int x,int[]parent)
    {
        if(x==parent[x])
        return x;

        return getParent(parent[x],parent);
    }
	
    public boolean union(int[]parent,int[]rank,int x,int y)
    {
		int p1=getParent(x,parent); 
        int p2=getParent(y,parent);
        
        if(p1!=p2)
        {
            if(rank[p1]>rank[p2])
            {
                parent[p2]=p1;
            }
            else if(rank[p2]>rank[p1])
            {
                parent[p1]=p2;
            }
            else
            {
                parent[p2]=p1;
                rank[p1]++;
            }
            return false;      
        }
        return true;  
    }
}