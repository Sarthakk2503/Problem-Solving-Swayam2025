class Solution {
    public int rob(int[] nums) {
      int n=nums.length;

      if(n==1)
       return nums[0];
      if(n==2)
       return Math.max(nums[0], nums[1]);

      int[] memo=new int[n];
      Arrays.fill(memo,-1);

      int firstTaken= calculateMax(nums,0,n-2,memo); 
      Arrays.fill(memo,-1);

      int lastTaken= calculateMax(nums,1,n-1,memo);
      return Math.max(firstTaken,lastTaken);

    }
    public int calculateMax(int[] nums,int start,int i,int[] memo)
    {
       if(i<start)
	   return 0;
	   if(i==start)
	   return nums[i];

	  if(memo[i]!=-1)
	  return memo[i]; 

      int take=nums[i]+calculateMax(nums,start,i-2,memo);
	  int nottake=0+calculateMax(nums,start,i-1,memo);
	  
	  return memo[i]=Math.max(take, nottake);
    }
}