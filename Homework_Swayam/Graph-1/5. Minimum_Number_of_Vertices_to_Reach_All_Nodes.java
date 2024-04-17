class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited=new boolean[n];
        List<Integer> list=new ArrayList();
        for(List<Integer> l:edges)
        {
            visited[l.get(1)]=true;
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            list.add(i);
        }
        return list;
    }
}