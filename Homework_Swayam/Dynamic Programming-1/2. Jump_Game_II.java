
// memoization
class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return helper(0,nums,n,memo);
    }
    public int helper(int i,int[] nums,int n,int[] memo)
    {
       if(i==n-1)
       return 0;
       if(memo[i]!=-1)
       return memo[i];

       int min=(int)1e5;
       for(int j=i+1;(j<=i+nums[i] && j<n);j++)
       {
        min=Math.min(min,helper(j,nums,n,memo)+1);
        
       }
       return memo[i]=min;
    }
}

// Recursion
// class Solution {
//     public int jump(int[] nums) {
//         int n=nums.length;
//         return helper(0,nums,n);
//     }
//     public int helper(int i,int[] nums,int n)
//     {
//        if(i==n-1)
//        return 0;

//        int min=(int)1e5;
//        for(int j=i+1;(j<=i+nums[i] && j<n);j++)
//        {
//         min=Math.min(min,helper(j,nums,n)+1);
//        }
//        return min;
//     }
// }