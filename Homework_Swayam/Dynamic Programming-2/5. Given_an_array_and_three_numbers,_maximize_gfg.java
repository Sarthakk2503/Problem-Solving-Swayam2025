import java.util.*;
class solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter 3 numbers");
        int x=in.nextInt();
        int y=in.nextInt();
        int z=in.nextInt();
        System.out.println("Enter length of Array");
	    int n=in.nextInt();

	    int[] ar=new int[n];
	    System.out.println("Enter Array Elements");
	    for(int i=0;i<n;i++)
	    ar[i]=in.nextInt();

	    int[] left=new int[n];
	    left[0]=ar[0]*x;

	    for(int i=1;i<n;i++)
	    {
		    left[i]=Math.max(ar[i]*x,left[i-1]);
	    }

	    int[] right=new int[n];
	    right[n-1]=ar[n-1]*z;
	    
	    for(int i=n-2;i>=0;i--)
	    {
		    right[i]=Math.max(ar[i]*x,right[i+1]);
	    }

	    int ans=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++)
	    {
            ans=Math.max(left[i]+right[i]+ar[i]*y,ans);
	    }
	    System.out.println(ans);
    }
}