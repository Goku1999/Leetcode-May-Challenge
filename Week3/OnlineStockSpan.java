/*Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].*/

import java.util.*;
class StockSpanner 
{
    Stack<int[]> stack;
    int top;
    public StockSpanner() 
    {
        stack=new Stack<int[]>();
        top=-1;
    }
    
    public int next(int price) 
    {
        int ans=1;
        while(!stack.isEmpty()&&price>=stack.peek()[1])
        {
            ans=ans+stack.pop()[0];
        }
        stack.push(new int[]{ans,price});
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
