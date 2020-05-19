/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

You may assume that both strings contain only lowercase letters.*/


class Solution {
    public boolean canConstruct(String s1, String s2) 
    {
        int a1[]=new int[26];
        int a2[]=new int[26];
        for(int x=0;x<s1.length();x++)
        {
            a1[s1.charAt(x)-97]++;
        }
        for(int x=0;x<s2.length();x++)
        {
            a2[s2.charAt(x)-97]++;
        }
        for(int x=0;x<26;x++)
        {
            if(a2[x]<a1[x])
            {
                return false;
            }
        }
        return true;
    }
}
