class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
		int low=0;
		int high=stalls[n-1]-stalls[0];
		int ans=1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(isPossibleDistance(mid,n,k,stalls))
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
    public static boolean isPossibleDistance(int distance,int n,int c,int[] stall)
	{
		int lastPlacedCow=stall[0];
		int placed=1;
		for(int i=1;i<n;i++)
		{
			if(stall[i]-lastPlacedCow >=distance)
			{
				lastPlacedCow=stall[i];
				placed++;
			}
		}
		return (placed>=c);
    }
}