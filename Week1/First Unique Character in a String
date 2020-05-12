class Solution 
{
    public int firstUniqChar(String s) 
    {
        int freq[]=new int[26];
        for(int x=0;x<s.length();x++)
        {
            freq[s.charAt(x)-97]++;
        }
        for(int x=0;x<s.length();x++)
        {
            if(freq[s.charAt(x)-97]==1)
            {
                return x;
            }
        }
        return -1;
    }
}
