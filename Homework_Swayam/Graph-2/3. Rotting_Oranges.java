class Trio{
    int i;
    int j;
    int time;
    Trio(int i,int j,int time)
    {
        this.i=i;
        this.j=j;
        this.time=time;
    }
}
class Solution {
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
       return minTimeToRott(grid);
    }
    public int minTimeToRott(int[][] grid)
    {
        Queue<Trio> q=new LinkedList();
        int fresh=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                q.add(new Trio(i,j,0));
                else if(grid[i][j]==1)
                fresh+=1;
            }
        }
        int time=0;
        while(!q.isEmpty())
        {
            Trio temp=q.poll();
            time=temp.time;
            for(int[] dir:directions)
            {
                int newr=temp.i+dir[0];
                int newc=temp.j+dir[1];

                if(newr<0 || newc<0 || newr>=grid.length || newc>=grid[0].length || grid[newr][newc]!=1)
                continue;

                fresh-=1;
                grid[newr][newc]=2;
                q.add(new Trio(newr,newc,temp.time+1));
            }
        }
        return fresh==0?time:-1;
    }
}