import java.util.*;
class solution
{
  public static void main(String args[])
  {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    int m=in.nextInt();
    int k=in.nextInt();
    
    int[] a=new int[n];
    int[] b=new int[m];
    
    for(int i=0;i<n;i++)
    a[i]=in.nextInt();
    for(int i=0;i<m;i++)
    b[i]=in.nextInt();
    
    Arrays.sort(a);
    Arrays.sort(b);
    
    int low=0;
    int high=n+m;
    int ans=0;
    
    while(low<=high)
    {
      int mid=low+(high-low)/2;
      if(isPossible(a,b,k,mid))
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
  public static boolean isPossible(int[] a,int[] b,int k,int val)
  {
    int i=0,j=0;
    int sum=0;
    while((i<a.length && j<b.length) && val>0)
    {
      if(a[i]<b[j])
      {
        sum+=a[i];
        i++;
      }
      else
      {
        sum+=b[j];
        j++;
      }
      val--;
    }
    while(val>0 && i<a.length)
    {
      sum+=a[i];
      val--;
      i++;
    }
    while(val>0 && j<b.length)
    {
      sum+=b[j];
      j--;
      val--;
    }
    
    return sum<=k;
  }
}