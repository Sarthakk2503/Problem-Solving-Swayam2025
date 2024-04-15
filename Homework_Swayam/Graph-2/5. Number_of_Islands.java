class Solution {
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1')
        return;

        grid[i][j]='0';
        for(int[] dir:directions)
        {
            int newr=i+dir[0];
            int newc=j+dir[1];

            dfs(grid,newr,newc);
        }
    }
}