/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/

class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        int l=p.length();
        int c[]=new int[26];
        for(int x=0;x<l;x++)
        {
            c[p.charAt(x)-97]++;
        }
        List<Integer> ar=new ArrayList<Integer>();
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
                ar.add(x);
            }
        }
        return ar;
    }
}
