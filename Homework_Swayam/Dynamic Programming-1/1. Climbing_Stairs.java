// 1. Bottom up Approach
class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// 2. Memoization 
// class Solution {
//     public int climbStairs(int n) {
//        int memo[]=new int[n];
//        Arrays.fill(memo,-1);
//        return helper(0,n,memo); 
//     }
//     public int helper(int i,int n,int[] memo)
//     {
//         if(i>n)
//         return 0;
//         if(i==n)
//         return 1;
//         if(memo[i]!=-1)
//         return memo[i];

//         int a=helper(i+1,n,memo);
//         int b=helper(i+2,n,memo);
//         return memo[i]=a+b;
//     }
// }

// 3. Recursion
// class Solution {
//     public int climbStairs(int n) {
//         return helper(0,n);
//     }
//     public int helper(int i,int n)
//     {
//         if(i>n)
//         return 0;
//         if(i==n)
//         return 1;

//         int a=helper(i+1,n);
//         int b=helper(i+2,n);
//         return a+b;
//     }
// }