import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
        for(int j=0;j<t;j++)
        {
         int n=in.nextInt();
		int c=in.nextInt();
		int[] stall=new int[n];
		for(int i=0;i<n;i++)
		{
			stall[i]=in.nextInt();
		}
		Arrays.sort(stall);
		int low=0;
		int high=stall[stall.length-1]-stall[0];
		int ans=1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(isPossibleDistance(mid,n,c,stall))
			{
				ans=mid;
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		System.out.println(ans);
	}
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