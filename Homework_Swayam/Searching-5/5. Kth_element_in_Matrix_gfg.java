class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        int ans=0;
        int low=mat[0][0];
        int high=mat[n-1][n-1];
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(blackBox(mat,mid)>=k)
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
    public static int blackBox(int[][] mat,int val)
    {
        int count=0;
        int i=0;
        int j=mat[0].length-1;
        
        while(i<mat.length && j>=0)
        {
            if(mat[i][j]>val)
            {
                j--;
            }
            else
            {
                count=count+j+1;
                i++;
            }
        }
        return count;
    }
}