class Solution {
    public int majorityElement(int[] nums) 
    {
        int n=nums.length;
        for(int x=0;x<n;x++)
        {
            int count=1;
            for(int y=x+1;y<n;y++)
            {
                if(nums[x]==nums[y])
                {
                    count++;
                }
            }
            if(count>n/2)
            {
                return nums[x];
            }
        }
        return -1;
    }
    
}
