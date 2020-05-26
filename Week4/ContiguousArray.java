/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.*/


class Solution 
{
    public int findMaxLength(int[] ar) 
    {
        int n=ar.length;
        int max=0;
        int s=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int x=0;x<n;x++)
        {
            //System.out.println("A"+ar[x]);
            s=s+(ar[x]==0?-1:1);
            //System.out.println(s);
            if(s==0)
            {
                if(x+1>max)
                {
                    max=x+1;
                }
            }
            if(map.containsKey(s))
            {
               int y=map.get(s);
                if(x-y>max)
                {
                    max=x-y;
                }
            }
            else
            {
                map.put(s,x);
            }
        }
        if(s==0)
        {
            max=n;
        }
        return max;
    }
}
