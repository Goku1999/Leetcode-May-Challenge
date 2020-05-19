/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/

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
