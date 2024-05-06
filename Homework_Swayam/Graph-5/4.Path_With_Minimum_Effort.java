class Solution {
    int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] distance=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
            int[] temp=pq.poll();
            int wt=temp[0];
            int row=temp[1];
            int col=temp[2];

            if(row==n-1 && col==m-1)
            return wt;

            for(int[] dir:directions)
            {
                int nr=row+dir[0];
                int nc=col+dir[1];

                if(nr>=0 && nc>=0 && nr<n && nc<m)
                {
                    int dis=Math.max(wt,Math.abs(heights[row][col]-heights[nr][nc]));
                    if(dis<distance[nr][nc])
                    {
                        distance[nr][nc]=dis;
                        pq.offer(new int[]{dis,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}