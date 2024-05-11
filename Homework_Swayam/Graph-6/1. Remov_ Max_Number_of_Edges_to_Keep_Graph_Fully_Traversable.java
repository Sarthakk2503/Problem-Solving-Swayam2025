class DSU {
    int max=0;
    ArrayList<Integer> parent= new ArrayList<>();
    ArrayList<Integer> rank= new ArrayList<>();

    public DSU(int n){
        for(int i=0;i<n;i++)
        {
            rank.add(1);
            parent.add(i);
        }
    }

    public boolean union(int u,int v) {
        int x = getParent(u);
        int y = getParent(v);
        if(x==y) return false;
        else{
            int sum= rank.get(x)+ rank.get(y);
            max= Math.max(max, sum);
            if(rank.get(x)<rank.get(y))
            {
                parent.set(x,y);
                rank.set(y,sum);
            }
            else
            {
                parent.set(y,x);
                rank.set(x, sum);
            }
            return true;
        }
    }
    public int getParent(int a) 
    {
        if(a==parent.get(a))
        return a;

        return getParent(parent.get(a));
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[][] sortedEdges= new int[edges.length][4];
        HashSet<Integer> set= new HashSet<>();
        int i=0;

        for(int[] edge: edges){
            sortedEdges[i][0]=edge[0];
            sortedEdges[i][1]=edge[1]-1;
            sortedEdges[i][2]=edge[2]-1;
            sortedEdges[i][3]=i;
            i++;
        }
        Arrays.sort(sortedEdges, (a,b)-> b[0]-a[0]);

        DSU alice= new DSU(n);
        for(int[] ed: sortedEdges)
        {
            if(ed[0]!=2)
            {
                if(alice.union(ed[1],ed[2]))
                set.add(ed[3]);
            }
        }
        if(alice.max!=n)
        return -1;

        DSU bob= new DSU(n);
        for(int[] edge: sortedEdges)
        {
            if(edge[0]!=1)
            {
                if(bob.union(edge[1], edge[2]))
                set.add(edge[3]);
            }
        }

        if(bob.max!=n)
        return -1;

        return edges.length-set.size();
    }
}