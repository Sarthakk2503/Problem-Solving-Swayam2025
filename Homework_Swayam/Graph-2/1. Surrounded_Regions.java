class Solution {
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int j=0;j<m;j++)
        {
            if(board[0][j]=='O')
            {
                dfs(board,0,j);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(board,i,0);
            }
        }
        for(int j=0;j<m;j++)
        {
            if(board[n-1][j]=='O')
            {
                dfs(board,n-1,j);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[i][m-1]=='O')
            {
                dfs(board,i,m-1);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='1')
                board[i][j]='O';
                else if(board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board,int i,int j)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O')
        return;

        board[i][j]='1';
        for(int[] dir:directions)
        {
            int newr=i+dir[0];
            int newc=j+dir[1];
            dfs(board,newr,newc);
        }
    }
}