class Solution {
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
