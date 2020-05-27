/*Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].*/

//Solution 1: Using BFS

class Solution {
    public boolean possibleBipartition(int n, int[][] dislike) 
    {
        LinkedList graph[]=new LinkedList[n];
        for(int x=0;x<n;x++)
        {
            graph[x]=new LinkedList<Integer>();
        }
        for(int x=0;x<dislike.length;x++)
        {
            int u=dislike[x][0]-1;
            int v=dislike[x][1]-1;
            graph[u].add(v);
            //graph[v].add(u);
        }
        for(int x=0;x<n;x++)
        {
            if(!color(graph,n,x))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean color(LinkedList<Integer> graph[],int n,int x)
    {
        int color[]=new int[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        color[x]=1;
        queue.add(x);
        boolean visited[]=new boolean[n];
        visited[x]=true;
        while(!queue.isEmpty())
        {
            int u=queue.poll();
            int c=color[u];
            Iterator<Integer> itr=graph[u].iterator();
            int d=1;
            if(c==1)
            {
                d=2;
            }
            while(itr.hasNext())
            {
                int v=itr.next();
                //System.out.println(u+" "+c+" "+color[v]);
                if(color[v]==c)
                {
                    return false;
                }
                if(!visited[v])
                {
                    visited[v]=true;
                    color[v]=d;
                    queue.add(v);
                }
            }
        }
        return true;
    }
}

Solution 2 : Using disjoint set

class Solution {
    public boolean possibleBipartition(int n, int[][] dislike) 
    {
        int parent[]=new int[n];
        for(int x=0;x<n;x++)
        {
            parent[x]=x;
        }
        for(int x=0;x<dislike.length;x++)
        {
            int u=dislike[x][0]-1;
            int v=dislike[x][1]-1;
            if(parent[u]==u&&parent[v]==v)
            {
                parent[u]=v;
                parent[v]=u;
            }
            else if(parent[v]==v)
            {
                parent[v]=parent[parent[u]];
            }
            else if(parent[u]==u)
            {
                parent[u]=parent[parent[v]];
            }
            else if(parent[u]==parent[v])
            {
                return false;
            }
        }
        return true;
    }
}
