class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] indegree=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int j:adj.get(i))
            {
                indegree[j]++;
            }
            
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }
        int ans=0;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            ans++;
            
            for(int i:adj.get(curr))
            {
                indegree[i]--;
                if(indegree[i]==0)
                q.offer(i);
            }
        }
        if(ans==V)
        return false;
        else
        return true;
    }
}