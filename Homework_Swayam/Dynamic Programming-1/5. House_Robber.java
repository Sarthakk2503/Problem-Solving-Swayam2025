// Tabulation
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        
        for(int i=1;i<n+1;i++)
        {
            if(i==1){
                dp[i]=nums[0];
            }
            else
            {
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }
        }
        return dp[n];
    }
}

// -> Memoisation Code
// class Solution {
//     public int rob(int[] nums) {
//         int[] memo=new int[nums.length];
//         Arrays.fill(memo,-1);
//         return helper(nums,nums.length-1,memo);
//     }
//     public int helper(int[] nums,int i,int[] memo)
//     {
//         if(i<=-1)
//         return 0;
//         if(memo[i]!=-1)
//         return memo[i];

//         int take=nums[i]+helper(nums,i-2,memo);
//         int notTake=helper(nums,i-1,memo);
//         memo[i]=Math.max(take,notTake);
//         return memo[i];
//     }
// }

// -> Recursion code gives TLE 

// class Solution {
//     public int rob(int[] nums) {
//         return helper(nums,nums.length-1);
//     }
//     public int helper(int[] nums,int i)
//     {
//         if(i<=-1)
//         return 0;

//         int take=nums[i]+helper(nums,i-2);
//         int nottake=helper(nums,i-1);

//         return Math.max(take,nottake);
//     }
// }