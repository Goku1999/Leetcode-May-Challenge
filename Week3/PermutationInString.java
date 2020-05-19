/*Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].*/

class Solution 
{
    public boolean checkInclusion(String p, String s) 
    {
        int l=p.length();
        int c[]=new int[26];
        for(int x=0;x<l;x++)
        {
            c[p.charAt(x)-97]++;
        }
        for(int x=0;x<=s.length()-l;x++)
        {
            int d[]=new int[26];
            for(int y=x;y<x+l;y++)
            {
                d[s.charAt(y)-97]++;
            }
            boolean add=true;
            for(int y=0;y<26;y++)
            {
                if(d[y]!=c[y])
                {
                    add=false;
                    break;
                }
            }
            if(add)
            {
                return true;
            }
        }
        return false;
    }
}
