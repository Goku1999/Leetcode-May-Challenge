class Solution {
    public int findComplement(int num) 
    {
        int ar[]=new int[32];
        ar[0]=1;
        for(int x=1;x<32;x++)
        {
            ar[x]=ar[x-1]*2+1;
        }
        int x=0;
        while(num>ar[x])
        {
            x++;
        }
        return ar[x]-num;
    }
}
