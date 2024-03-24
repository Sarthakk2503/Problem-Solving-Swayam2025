import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {


        if(m<n)
        return kthElement(arr2,arr1,m,n,k);

        int low=Math.max(0,k-m);
        int high=Math.min(k,n);

        //System.out.println("low : "+low+" high : "+high);
        while(low<=high)
        {
            int amid=(low+high)/2;
            int bmid=k-amid;

            int aleft=amid==0?Integer.MIN_VALUE:arr1.get(amid-1);
            int bleft=bmid==0?Integer.MIN_VALUE:arr2.get(bmid-1);
            int aright=amid>=n?Integer.MAX_VALUE:arr1.get(amid);
            int  bright=bmid>=m?Integer.MAX_VALUE:arr2.get(bmid);

            if(aleft<=bright && bleft<=aright)
            return Math.max(aleft,bleft);

            else if(aleft>bright)
            {
                high=amid-1;
            }
            else{
                low=amid+1;
            }

        }
        return -1;
    }
}