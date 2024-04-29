class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> ans=new ArrayList();
        List<List<Integer>> adj=new ArrayList();
        int[] indegree=new int[n];
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
            ans.add(new HashSet<Integer>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            ans.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++)
        {
            for(int j:adj.get(i))
            indegree[j]++;
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }
        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int i:adj.get(node))
            {
                indegree[i]--;
                if(indegree[i]==0)
                q.offer(i);
                ans.get(i).addAll(ans.get(node));
            }
        }
        List<List<Integer>> l=new ArrayList<>();
        for(Set<Integer> s: ans)
        {
            l.add(new ArrayList<>(s));
            Collections.sort(l.get(l.size()-1));
        }
        return l;
    }
}