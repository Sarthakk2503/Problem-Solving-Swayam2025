class Solution {
    public boolean search(int[] nums, int target) {
              int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]==target)
            {
                return true;
            }
            else if(nums[start]<=nums[mid])
            {
                if(nums[start]==nums[mid])
                {
                    start++;
                }
                else if(target>=nums[start] && target<nums[mid])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            else
            {
                if(nums[mid]==nums[end])
                {
                    end--;
                }
                else if(target>nums[mid] && target<=nums[end])
                {
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }
        return false;
    }
}