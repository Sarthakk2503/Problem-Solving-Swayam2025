class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(low==high)
            return nums[mid];
            else if(mid==0 && nums[mid]!=nums[mid+1])
            {
                return nums[mid];
            }
            else if(mid==nums.length-1 && nums[mid]!=nums[mid-1])
            {
                return nums[mid];
            }
            else if(mid-1>=0 && mid+1<nums.length && nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
            {
                return nums[mid];
            }
            if(mid-1 >= 0 && nums[mid]==nums[mid-1])
            {
                if((mid-1)%2==0)
                low=mid+1;
                else
                high=mid-1;
            }
            else
            {
                if(mid%2==0)
                low=mid+1;
                else
                high=mid-1;
            }
        }
        return ans;
    }
}