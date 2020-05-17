class Solution {
    public boolean isPerfectSquare(int num) 
    {
        if(num==1)
        {
            return true;
        }
        for(int x=1;x<=num/2;x++)
        {
            if(x*x==num)
            {
                return true;
            }
        }
        return false;
    }
}
