// Bottom up Approach
class Solution{
    static int maxSum(int N, int mat[][])
    {
        // code here
        int[] dp=new int[N];
        Arrays.fill(dp,0);
        
       dp[N-1]=Math.max(mat[0][N-1],mat[1][N-1]);
       dp[N-2]=Math.max(dp[N-1], Math.max(mat[0][N-2], mat[1][N-2]));
       
       for(int i=N-3;i>=0;i--){
          int notake=dp[i+1];
          int take=Math.max(mat[0][i],mat[1][i])+dp[i+2];
          dp[i]=Math.max(take,notake); 
       }
       return dp[0];
    }
}

// Memoization

class Solution{
    static int maxSum(int N, int mat[][])
    {
        int[][] memo=new int[3][N];
        for(int i=0;i<mat.length;i++)
        Arrays.fill(memo[i],-1);
        return Math.max(helper(0,0,mat,memo,N),helper(1,0,mat,memo,N));
    }
    public static int helper(int r,int c,int[][] mat,int[][] memo,int n)
    {
        if(c>=n)
        return 0;
        if(memo[r][c]!=-1)
        return memo[r][c];
        
        int take=mat[r][c]+Math.max(helper(1,c+2,mat,memo,n),helper(0,c+2,mat,memo,n));
        int notake=helper(1,c+1,mat,memo,n);
        int notake2=helper(0,c+1,mat,memo,n);
        
        return memo[r][c]=Math.max(take,Math.max(notake,notake2)); 
    }
}