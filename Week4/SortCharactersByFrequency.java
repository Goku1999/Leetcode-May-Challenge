/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer/
Note that "cacaca" is incorrect, as the same characters must be together.*/

class Solution 
{
    public String frequencySort(String s) 
    {
        StringBuffer sb=new StringBuffer("");
        int ar[]=new int[129];
        for(int x=0;x<s.length();x++)
        {
            char ch=s.charAt(x);
            ar[ch]++;
        }
        for(int y=0;y<s.length();y++)
        {
            int max=0;
            int i=-1;
            for(int x=0;x<ar.length;x++)
            {
                if(max<ar[x])
                {
                    max=ar[x];
                    i=x;
                }
            }
            if(i==-1)
            {
                break;
            }
            ar[i]=-1;
            for(int x=0;x<max;x++)
            {
                sb.append((char)(i)+"");
            }
        }
        return sb.toString();
    }
}
