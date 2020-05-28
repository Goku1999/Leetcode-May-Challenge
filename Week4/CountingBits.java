/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.*/

class Solution 
{
    public int[] countBits(int num) 
    {
        if(num==0)
        {
            return new int[]{0};
        }
        else if(num==1)
        {
            return new int[]{0,1};
        }
        long power[]=new long[32];
        power[0]=1l;
        for(int x=1;x<32;x++)
        {
            power[x]=power[x-1]*2l;
        }
        int ar[]=new int[num+1];
        ar[0]=0;
        int i=1;
        ar[1]=1;
        for(int x=2;x<=num;x++)
        {
            if(x==power[i])
            {
               ar[x]=1;
                i++;
                continue;
            }
            int d=(int)(x-power[i-1]);
            ar[x]=1+ar[d];
        }
        return ar;
    }
}
