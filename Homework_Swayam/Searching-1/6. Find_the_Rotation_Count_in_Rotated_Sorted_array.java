
public class Find_the_Rotation_Count_in_Rotated_Sorted_array
{
    public static void main(String args[])
    {
        int[] a ={15,18,2,3,6,12};
        int low=0;
        int high=a.length-1;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid==0 || a[mid]<a[mid-1])
            {
                ans=mid;
                break;
            }
            if(a[mid]<a[high])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        System.out.println(ans);
    }
}