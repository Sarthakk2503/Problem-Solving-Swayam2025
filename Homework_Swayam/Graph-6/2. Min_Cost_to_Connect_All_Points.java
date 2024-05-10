class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans = 0;
        int visited = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);

        int[] dist=new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{0,0});
        while(visited<points.length)
        {
            int[] cur=pq.poll();
            if (dist[cur[0]]<0)
            continue;

            ans+=cur[1];
            dist[cur[0]]=-1;
            visited++;

            for (int i=0; i<points.length; i++) {
                if (dist[i]<0)
                continue;
                int d = findDistance(i,cur[0],points);
                if (d<dist[i])
                {
                    pq.offer(new int[]{i,d});
                    dist[i]=d;
                }
            }
        }
        return ans;
    }
    public int findDistance(int i, int j, int[][] points)
    {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}