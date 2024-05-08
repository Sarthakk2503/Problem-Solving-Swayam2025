// Memoization

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       long[] memo=new long[n+1];
       Arrays.fill(memo,-1);
       return ways(n,memo);
    }
    public long ways(int n,long[] memo)
    {
        if(n==0)
        return 1;
        if(memo[n]!=-1)
        return memo[n];
        
        long single=ways(n-1,memo);
        long pair=0;
        
        if(n-2>=0)
        pair =ways(n-2,memo)*(n-1);
        
        return memo[n]=(single+pair)%1000000007;
    }
}

// Recursion

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       return ways(n);
    }
    public long ways(int n)
    {
        if(n==0)
        return 1;
        
        long single=ways(n-1);
        long pair=0;
        
        if(n-2>=0)
        pair =ways(n-2)*(n-1);
        
        return (single+pair)%1000000007;
    }
}

// Bottom Up


class Solution
{
    public long countFriendsPairings(int n) 
    { 
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            long single=dp[i-1];
            long pair=0;
            if(i-2>=0)
            pair=dp[i-2]*(i-1);
            
            dp[i]=(single+pair)%1000000007;
        }
        return dp[n];
    }
}    