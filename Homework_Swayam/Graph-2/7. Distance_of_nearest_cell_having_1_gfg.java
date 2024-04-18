class Trio
{
    int x;
    int y;
    int distance;
    Trio(int i,int j,int dis)
    {
        this.x=i;
        this.y=j;
        this.distance=dis;
    }
}
class Solution
{
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int[][] ans=new int[n][m];
        
        bfs(grid,ans);
        return ans;
        
    }
    public void bfs(int[][] grid,int[][] ans)
    {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Trio> q=new LinkedList();
        boolean[][] visited=new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.offer(new Trio(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty())
        {
            Trio temp=q.poll();
            int x=temp.x;
            int y=temp.y;
            int dis=temp.distance;
            
            ans[x][y]=dis;
            for(int[] dir:directions)
            {
                int newx=x+dir[0];
                int newy=y+dir[1];
                
                if(newx<0 || newy<0 || newx>=n || newy>=m || visited[newx][newy])
                continue;
                
                visited[newx][newy]=true;
                q.add(new Trio(newx,newy,dis+1));
            }
        }
    }
}