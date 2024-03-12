class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k >bloomDay.length)
        return -1;

        int low=1;
        int high=-1;
        int ans=0;
        for(int a:bloomDay)
        {
            low=Math.min(low,a);
            high=Math.max(high,a);
        }

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canMakeBouquets(m,k,bloomDay,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean canMakeBouquets(int m,int k,int[] bloom,int day)
    {
        int conti=0;
        int count=0;
        for(int i=0;i<bloom.length;i++)
        {
            if(day>=bloom[i])
            {
                conti++;
                if(conti==k)
                {
                    count++;
                    conti=0;
                }
            }
            else
            {
                conti=0;
            }
        }
        return count>=m;
    }
}