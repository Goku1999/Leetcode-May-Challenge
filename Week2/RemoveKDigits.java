class Solution 
{
    public String removeKdigits(String num, int k) 
    {
        if(num.length()==1)
        {
            return "0";
        }
        for(int x=0;x<k;x++)
        {
            if(num.length()==1)
            {
                num="0";
                break;
            }
            num=remove(num);
            //System.out.println(num);
        }
        num=trim(num);
        if(num.length()==0)
        {
            num="0";
        }
        return num;
    }
    public String trim(String s)
    {
        int x=0;
        while(x<s.length()&&s.charAt(x)=='0')
        {
            x++;
        }
        return s.substring(x);
    }
    public String remove(String s)
    {
        for(int x=1;x<s.length();x++)
        {
            if(s.charAt(x-1)>s.charAt(x))
            {
                return s.substring(0,x-1)+s.substring(x);
            }
        }
        for(int x=s.length()-1;x>=1;x--)
        {
            if(s.charAt(x)>=s.charAt(x-1))
            {
                return s.substring(0,x);
            }
        }
        return s;
    }
}
