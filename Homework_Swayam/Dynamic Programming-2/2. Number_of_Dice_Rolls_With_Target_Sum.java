// Memoization

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo=new int[n+1][target+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(memo[i],-1);
        return helper(n,k,target,0,memo);
    }
    public int helper(int n,int k,int target,int sum,int[][] memo)
    {
        if(n==0 && sum==target)
        return 1;
        if(n==0 || sum>target)
        return 0;
        if(memo[n][sum]!=-1)
        return memo[n][sum];

        int ways=0;
        for(int i=1;i<=k;i++)
        {
            sum+=i;
            ways=(ways+helper(n-1,k,target,sum,memo))%1000000007;
            sum-=i;
        }
        return memo[n][sum]=ways;
    }
}

// Recursion

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
       
        return helper(n,k,target,0);
    }
    public int helper(int n,int k,int target,int sum)
    {
        if(n==0 && sum==target)
        return 1;
        if(n==0 || sum>target)
        return 0;

        int ways=0;
        for(int i=1;i<=k;i++)
        {
            sum+=i;
            ways=(ways+helper(n-1,k,target,sum))%1000000007;
            sum-=i;
        }
        return ways;
    }
}

// Bottom Up Approach

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],0);
        dp[0][0]=1;
        
        for(int i=1;i<=n;i++)
        {
            for(int t=0;t<=target;t++)
            {
                int ways=0;
                for(int j=1;j<=k;j++)
                {
                    if(t-j>=0)
                    ways=(ways+dp[i-1][t-j])%1000000007;
                }
                dp[i][t]=ways;
            }
        }
        return dp[n][target];
    }
}
