/**Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.*/

class Solution 
{
    public int countSquares(int[][] ar) 
    {
        int count=0;
        int n=ar.length;
        int m=ar[0].length;
        int arr[][]=new int[n][m];
        for(int x=0;x<n;x++)
        {
            arr[x][0]=ar[x][0];
        }
        for(int y=0;y<m;y++)
        {
            arr[0][y]=ar[0][y];
        }
        for(int x=0;x<n;x++)
        {
            for(int y=0;y<m;y++)
            {
                if(x>0&&y>0&&ar[x][y]>0)
                {
                    arr[x][y]=Math.min(arr[x-1][y-1],Math.min(arr[x][y-1],arr[x-1][y]))+1;
                }
                //System.out.println(x+" "+y+" "+arr[x][y]);
                count+=arr[x][y];
            }
        }
        return count;
    }
}
