public class DSU{
        int[] parent;
        int n;
        public DSU(int n)
        {
            this.n = n;
            this.parent = new int[n];
            Arrays.fill(this.parent,-1);
        }

        public int getParent(int n)
        {
            if (parent[n]<0)
            return n;

            parent[n]=getParent(parent[n]);
            return parent[n];
        }

        public boolean union(int i,int j)
        {
            int x=getParent(i);
            int y=getParent(j);

            if (x==y)
            return false;

            if (Math.abs(parent[x])>=Math.abs(parent[y]))
            {
                parent[x]+=parent[y];
                parent[y]=x;
            }
            else
            {
                parent[y]+=parent[x];
                parent[x]=y;
            }
            return true;
        }
    }
    
class Solution {
    public int minSwapsCouples(int[] row) {
        if (row==null || row.length<2)
        return 0;

        int ans=0;
        DSU disjointSets=new DSU(row.length/2);

        for (int i=0;i<row.length;i=i+2)
        {
            if (!isCouple(row[i],row[i+1]))
            {
                if (disjointSets.union(row[i]/2,row[i+1]/2))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isCouple(int i,int j)
    {
        boolean a=(Math.min(i,j) & 1)==0;
        boolean b=Math.abs(i-j)==1;
        return a && b;
    }
}