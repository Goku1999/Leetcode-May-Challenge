class Solution 
{
    public int singleNonDuplicate(int[] nums) 
    {
        for(int x=0;x<nums.length-1;x++)
        {
            if(nums[x]==nums[x+1])
            {
                x++;
            }
            else
            {
                return nums[x];
            }
        }
        return nums[nums.length-1];
    }
    
}
