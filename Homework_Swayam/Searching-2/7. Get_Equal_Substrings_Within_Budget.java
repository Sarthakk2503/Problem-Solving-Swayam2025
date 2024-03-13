class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int low=0;
        int high=s.length();
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isPossible(mid,s,t,maxCost))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    boolean isPossible(int length,String s,String t,int maxCost)
    {
        if(length==0)
        return true;

        int ans=Integer.MAX_VALUE;
        int sum=0;
        int start=0;
        int end=0;

        while(end<s.length())
        {
            sum+=Math.abs((s.charAt(end)-'a')-(t.charAt(end)-'a'));
            if(end-start+1 == length)
            {
                ans=Math.min(ans,sum);
                sum-=Math.abs((s.charAt(start)-'a')-(t.charAt(start)-'a'));
                start++;
            }
            end++;
        }
        return ans<=maxCost;

    }
}