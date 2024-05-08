// Memoization

class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return helper(s,0,memo);
    }
    public int helper(String s,int i,int[] memo)
    {
        if(i==s.length())
        return 1;
        if(s.charAt(i)=='0')
        return 0;
        if(i==s.length()-1)
        return 1;

        if(memo[i]!=-1)
        return memo[i];

        int ways=helper(s,i+1,memo);
        if((s.charAt(i)-'0')*10 +(s.charAt(i+1)-'0')<=26)
        ways+=helper(s,i+2,memo);

        return memo[i]=ways;
    }
}

// Recursion

class Solution {
    public int numDecodings(String s) {
        return helper(s,0);
    }
    public int helper(String s,int i)
    {
        if(i==s.length())
        return 1;
        if(s.charAt(i)=='0')
        return 0;
        if(i==s.length()-1)
        return 1;

        int ways=helper(s,i+1);
        if((s.charAt(i)-'0')*10 +(s.charAt(i+1)-'0')<=26)
        ways+=helper(s,i+2);

        return ways;
    }
}

// Bottom up

class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);

        dp[n]=1;
        dp[n-1]=s.charAt(n-1)=='0'?0:1;

        for(int i=n-2;i>=0;i--)
        {
            if(s.charAt(i)=='0')
            {
                continue;
            }
            dp[i]=dp[i+1];
            int num=(s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
            if(num<=26)
            dp[i]+=dp[i+2];
        }
        return dp[0];
    }
}