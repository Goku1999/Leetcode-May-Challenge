/*We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
 

Note:

1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000*/

class Solution 
{
    int ar[][];
    public int maxUncrossedLines(int[] A, int[] B) 
    {
        ar=new int[A.length+1][B.length+1];
        for(int x=0;x<ar.length;x++)
        {
            for(int y=0;y<ar[0].length;y++)
            {
                ar[x][y]=-1;
            }
        }
        max(A,B,0,0);
        int max=-1;
        for(int x=0;x<ar.length;x++)
        {
            for(int y=0;y<ar[0].length;y++)
            {
                //System.out.println(ar[x][y]);
                if(ar[x][y]>max)
                {
                    max=ar[x][y];
                }
            }
        }
        return max;
    }
    public int max(int a[],int b[],int i,int j)
    {
        if(i==a.length||j==b.length)
        {
            ar[i][j]=0;
            return ar[i][j];
        }
        else
        {
            int d=0;
            if(a[i]==b[j])
            {
                if(ar[i+1][j+1]==-1)
                {
                    ar[i+1][j+1]=max(a,b,i+1,j+1);
                }
                ar[i][j]=1+ar[i+1][j+1];
                return ar[i][j];
            }
            if(ar[i+1][j]==-1)
            {
                ar[i+1][j]=max(a,b,i+1,j);
            }
            if(ar[i][j+1]==-1)
            {
                ar[i][j+1]=max(a,b,i,j+1);
            }
            int e=ar[i+1][j];
            int f=ar[i][j+1];
            ar[i][j]=Math.max(e,f);
            return ar[i][j];
        }
    }
}
