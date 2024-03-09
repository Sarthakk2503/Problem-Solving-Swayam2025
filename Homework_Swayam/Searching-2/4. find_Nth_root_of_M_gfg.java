class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        long low=1;
        long high=m;
        long ans=-1;
        
        while(low<=high)
        {
            long mid=(low+high)/2;
            
            if(Math.pow(mid,n)==m)
            {
                ans=mid;
                return (int)ans;
            }
            else if(Math.pow(mid,n)<m)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}