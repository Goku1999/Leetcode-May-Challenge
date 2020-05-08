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
