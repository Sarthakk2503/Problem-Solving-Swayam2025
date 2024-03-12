import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=0;

        for(int x:boards)
        {
            low=Math.max(low,x);
            high+=x;
        }

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(canPaint(boards,mid,k))
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
    public static boolean canPaint(ArrayList<Integer> boards,int time,int k)
    {
        int sum=0;
        int count=1;

        for(int i=0;i<boards.size();i++)
        {
            sum+=boards.get(i);
            if(sum>time)
            {
                count++;
                sum=boards.get(i);
            }
        }
        return count<=k;
    }
}