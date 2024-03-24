
import java.util.*;
class solution {
    public static void main(String[] args) {
        int a=2,b=3,c=5,n=10;
        int low=0;
        int high=Integer.MAX_VALUE;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(countTerms(a,b,c,mid)==n)
            {
                ans=mid;
                high=mid-1;
            }
            else if(countTerms(a,b,c,mid)<n)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        System.out.println(ans);
    }
    public static int countTerms(int a,int b,int c,int mid)
    {
        int count=(mid/a)+(mid/b)+(mid/c)-(mid/(lcm(a,b)))-(mid/(lcm(b,c)))-(mid/(lcm(a,c)))+(mid/(lcm(a,lcm(b,c))));
        
        return count;
    }
    public static int lcm(int a,int b)
    {
        return (a*b)/gcd(a,b);
    }
    public static int gcd(int a,int b)
    {
        if(a==0)
        return b;
        
        return gcd(b%a,a);
    }
}