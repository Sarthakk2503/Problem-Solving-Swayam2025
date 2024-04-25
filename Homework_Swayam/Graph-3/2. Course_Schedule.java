class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList();
        int ans=0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }
        while(!q.isEmpty())
        {
            int curr=q.poll();
            ans++;

            for(int i:adj[curr])
            {
                indegree[i]--;
                if(indegree[i]==0)
                q.offer(i);
            }
        }
        return ans==numCourses;
    }
}