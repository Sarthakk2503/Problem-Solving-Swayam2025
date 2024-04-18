class Position{
    int x;
    int y;
    int moves;
    Position(int i,int j,int move)
    {
        this.x=i;
        this.y=j;
        this.moves=move;
    }
}

public class Solution {
    int[][] directions={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,-2},{-1,2},{1,-2}};
    public int knight(int A, int B, int C, int D, int E, int F) {
        if(C==E && D==F)
        return 0;
        return bfs(A,B,C,D,E,F);
    }
    public int bfs(int a,int b,int c,int d,int e,int f)
    {
        Queue<Position> q=new LinkedList();
        boolean[][] visited=new boolean[a][b];
        q.offer(new Position(c-1,d-1,0));
        visited[c-1][d-1]=true;
        
        while(!q.isEmpty())
        {
            Position temp=q.poll();
            if(temp.x==e-1 && temp.y==f-1)
            return temp.moves;
            
            for(int[] dir:directions)
            {
                int newx=temp.x+dir[0];
                int newy=temp.y+dir[1];
                
                if(newx<0 || newy<0 || newx>=a || newy>=b || visited[newx][newy])
                continue;
                
                visited[newx][newy]=true;
                q.offer(new Position(newx,newy,temp.moves+1));
            }
        }
        return -1;
    }
}
