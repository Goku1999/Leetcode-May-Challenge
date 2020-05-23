/*Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9*/

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) 
    {
        int n=A.length;
        int m=B.length;
        ArrayList<ArrayList<Integer>> ar=new ArrayList<ArrayList<Integer>>();
        int a=0;
        int b=0;
        while(a<n&&b<m)
        {
            ArrayList<Integer> r=new ArrayList<Integer>();
            if(A[a][0]>=B[b][0])
            {
                if(A[a][0]>B[b][1])
                {
                    //System.out.println(a+" "+b);
                    b++;
                    continue;
                }
                r.add(A[a][0]);
                if(A[a][1]<B[b][1])
                {
                    r.add(A[a][1]);
                    a++;
                }
                else
                {
                    r.add(B[b][1]);
                    b++;
                }
            }
            else
            {
                if(B[b][0]>A[a][1])
                {
                    a++;
                    continue;
                }
                r.add(B[b][0]);
                if(A[a][1]>B[b][1])
                {
                    r.add(B[b][1]);
                    b++;
                }
                else
                {
                    r.add(A[a][1]);
                    a++;
                }
            }
            ar.add(r);
        }
        int ans[][]=new int[ar.size()][2];
        for(int x=0;x<ar.size();x++)
        {
            ans[x][1]=ar.get(x).get(1);
            ans[x][0]=ar.get(x).get(0);
        }
        return ans;
    }
}
