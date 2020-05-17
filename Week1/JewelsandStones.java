class Solution {
    public int numJewelsInStones(String J, String S) 
    {
        int count=0;
            for(int x=0;x<S.length();x++)
            {
                if(J.indexOf(S.charAt(x))!=-1)
                {
                    count++;
                }
            }
        return count;
    }
}
