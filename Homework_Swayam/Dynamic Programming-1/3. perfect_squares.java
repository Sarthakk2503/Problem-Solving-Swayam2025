
// Tabulation
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=Math.floor(Math.sqrt(i));j++)
            {
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}

// Memoization Approach
// class Solution {
//     public int numSquares(int n) {
//         int[] memo=new int[n+1];
//         Arrays.fill(memo,-1);
//         return helper(n,memo);
//     }
//     public int helper(int n,int[] memo)
//     {
//         if(n==0)
//         return 0;
//         if(memo[n]!=-1)
//         return memo[n];

//         int min=(int)1e5;
//         for(int i=1;i*i<=n;i++)
//         {
//             min=Math.min(min,1+helper(n-i*i,memo));
//         }
//         return memo[n]=min;
//     }
// }
// Recursive Approach

// class Solution {
//     public int numSquares(int n) {
//         return helper(n);
//     }
//     public int helper(int n)
//     {
//         if(n==0)
//         return 0;

//         int min=(int)1e5;
//         for(int i=1;i*i<=n;i++)
//         {
//             min=Math.min(min,1+helper(n-i*i));
//         }
//         return min;
//     }
// }