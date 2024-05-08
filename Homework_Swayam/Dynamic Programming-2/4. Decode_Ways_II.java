// Memoization

class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        long[] memo = new long[n+1];
        Arrays.fill(memo,-1);
        return (int)helper(s,0,memo);
    }
     public long helper(String s,int i,long[] memo) 
     {
        if(i == s.length())
        return 1;
        if(memo[i] != -1) 
        return memo[i];
        
        char c=s.charAt(i);
        if(c=='0')
        return 0;
        
        long ans=0;
        if(c=='*')
        {
            ans+=9*helper(s,i+1,memo);
            if(i<s.length()-1) {
                char ss=s.charAt(i+1);
                if(ss=='*') {
                    ans+=15*helper(s,i+2,memo);
                } else {
                    if(ss>='0'&&ss<='6')
                    ans+=2*helper(s,i+2,memo);
                    else
                    ans+=helper(s,i+2,memo);
                }
            }
        } else {
            ans+=helper(s,i+1,memo);
            
            if(i<s.length()-1) {
                char ss=s.charAt(i+1);
                if(ss=='*') {
                    if(c=='1')
                    ans+=9*helper(s,i+2,memo);
                    else if(c=='2')
                    ans+=6*helper(s,i+2,memo);
                } else {
                    int n =((c-'0')*10)+(ss-'0'); 
                    if(n<=26){
                        ans+=helper(s,i+2,memo);
                    }
                }
            }
        }
        return memo[i]=ans%1000000007;
    }
}