class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean visited[]=new boolean[V];
       boolean currStack[]=new boolean[V];
       
       for(int i=0;i<V;i++)
       {
           boolean check=dfs(adj,visited,currStack,i);
           if(check)
           return true;
       }
       return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] currStack,int s)
    {
        if(currStack[s])
        return true;
        
        if(visited[s])
        return false;
        
        visited[s]=true;
        currStack[s]=true;
        List<Integer> neighbor=adj.get(s);
        
        for(int i:neighbor)
        {
            if(dfs(adj,visited,currStack,i))
            return true;
        }
        currStack[s]=false;
        return false;
    }
}