class Solution {
    public int maxSubarraySumCircular(int[] ar) 
    {
        int min=Integer.MIN_VALUE,sum=0;
        boolean p=true;
        boolean n=true;
        for(int x=0;x<ar.length;x++)
        {
            if(min<ar[x])
            {
                min=ar[x];
            }
            sum+=ar[x];
            if(ar[x]<=0)
            {
                p=false;
            }
            else
            {
                n=false;
            }
        }
        if(p)
        {
            return sum;
        }
        if(n)
        {
            return min;
        }
        return max(ar);
    }
    public int max(int ar[])
    {
        int n=ar.length;
        
        int l[]=new int[n];
        int maxL[]=new int[n];
        
        int r[]=new int[n];
        int maxR[]=new int[n];
        
        l[0]=ar[0];
        maxL[0]=Math.max(0,ar[0]);
        
        r[n-1]=ar[n-1];
        maxR[n-1]=Math.max(r[n-1],0);
        
        for(int x=1;x<n;x++)
        {
            l[x]=l[x-1]+ar[x];
            maxL[x]=Math.max(l[x],maxL[x-1]);
        }
        
        for(int x=n-2;x>=0;x--)
        {
            r[x]=r[x+1]+ar[x];
            maxR[x]=Math.max(r[x],maxR[x+1]);
        }
        
        int sum=0;
        int ans=0;
        
        for(int x=0;x<n;x++)
        {
            sum=sum+ar[x];
            if(sum>ans)
            {
                ans=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        
        int right=Integer.MIN_VALUE;
        int left=Integer.MIN_VALUE;
        
        for(int x=0;x<n-1;x++)
        {
            int d=maxL[x]+maxR[x+1];
            if(d>left)
            {
                left=d;
            }
        }
        return Math.max(ans,Math.max(left,right));
    }
}
