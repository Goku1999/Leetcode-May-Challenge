class Solution {
    public int findJudge(int n, int[][] trust) 
    {
        if(trust.length<n-1)
        {
            return -1;
        }
        int ar[]=new int[n];
        int br[]=new int[n];
        for(int x=0;x<trust.length;x++)
        {
            ar[trust[x][0]-1]++;
            br[trust[x][1]-1]++;
        }
        for(int x=0;x<n;x++)
        {
            if(ar[x]==0&&br[x]==n-1)
            {
                return x+1;
            }
        }
        return -1;
    }
}
