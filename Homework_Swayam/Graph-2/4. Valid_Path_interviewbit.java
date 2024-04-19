public class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        boolean[][] visited=new boolean[A+1][B+1];
        if(dfs(0,0,A,B,C,D,E,F,visited))
        return "YES";
        else
        return "NO";
    }
    public boolean dfs(int x,int y,int a,int b,int c,int d,ArrayList<Integer> e,ArrayList<Integer> f,boolean[][] vis)
    {
        if(x==a && y==b)
        return true;
        
        vis[x][y]=true;
        
        for(int[] dir:directions)
        {
            int nx=x+dir[0];
            int ny=y+dir[1];
            
            if(nx>=0 && nx<=a && ny>=0 && ny<=b && vis[nx][ny]==false)
            {
                if(isInsideCircle(nx,ny,c,d,e,f))
                {
                    if(dfs(nx,ny,a,b,c,d,e,f,vis))
                    return true;
                }
            }
        }
        return false;
    }
    boolean isInsideCircle(int x,int y,int c,int d, ArrayList<Integer> e,ArrayList<Integer> f)
    {
        for(int i=0;i<c;i++)
        {
            int cx=e.get(i);
            int cy=f.get(i);
            int dx=x-cx;
            int dy=y-cy;
            int dis=dx*dx+dy*dy;
            
            if(dis<=d*d)
            return false;
            
        }
        return true;
    }
}