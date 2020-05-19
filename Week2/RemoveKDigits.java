/*Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.*/

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
