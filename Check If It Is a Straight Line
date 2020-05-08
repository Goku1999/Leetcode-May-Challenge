class Solution {
    public boolean checkStraightLine(int[][] ar) 
    {
        if(ar.length==2)
        {
            return true;
        }
        int x=ar[0][0];
        int y=ar[0][1];
        int x1=ar[1][0];
        int y1=ar[1][1];
        double m=(double)(y1-y)/(x1-x);
        for(int i=2;i<ar.length;i++)
        {
            x1=ar[i][0];
            y1=ar[i][1];
            double slope=(double)(y1-y)/(x1-x);
            if(slope!=m)
            {
                return false;
            }
        }
        return true;
    }
}
