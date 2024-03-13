/*You have given an array A having N elements and an integer S. You have to find a maximum number X 
such that the sum of all its subarrays of size X is less than or equal to S.*/


class solution {
    public static void main(String[] args) {
        int[] ar={1, 3, 4, 2};
        int s=7;
        int low=0;
        int high=ar.length-1;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(isPossible(mid,ar,s))
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
    public static boolean isPossible(int size,int[] ar,int s)
    {
        int sum=0;
        int i=0;
        int j=0;
        while(j<ar.length)
        {
            sum+=ar[j];
            if(j-i+1 == size)
            {
                if(sum>s)
                return false;
                
                sum-=ar[i];
                i++;
            }
            j++;
        }
        return true;
    }
}
