// Bottom up Approach
class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];
        dp[n-1]=questions[n-1][0];
        for(int i=n-2;i>=0;i--)
        {
            long y=0l;
            if(i+questions[i][1]+1 <n)
            {
                y=dp[i+questions[i][1]+1];
            }
            dp[i]=Math.max(dp[i+1],questions[i][0]+y);
        }
        return dp[0];
    }
}


// Memoization 
// class Solution {
//     public long mostPoints(int[][] questions) {
//         int n=questions.length;
//         long[] memo=new long[n];
//         Arrays.fill(memo,-1);
//         return helper(0,questions,memo);
        
//     }
//     public long helper(int i,int[][] questions,long[] memo)
//     {
//         if(i>=questions.length)
//         return 0;
//         if(memo[i]!=-1)
//         return memo[i];

//         long take=questions[i][0]+helper(i+questions[i][1]+1,questions,memo);
//         long nottake=0+helper(i+1,questions,memo);
//         return memo[i]=Math.max(take,nottake);
//     }
// }

// Recursion 
// public long helper(int i,int[][] questions)
//     {
//         if(i>=questions.length)
//         return 0;

//         long take=questions[i][0]+helper(i+questions[i][1]+1,questions,memo);
//         long nottake=0+helper(i+1,questions,memo);
//         return Math.max(take,nottake);
//     }