/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

class Solution 
{
    public boolean canFinish(int n, int[][] pre) 
    {
        LinkedList ll[]=new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            ll[i]=new LinkedList<Integer>();
        }
        for(int i=0;i<pre.length;i++)
        {
            int a=pre[i][0];
            int b=pre[i][1];
            ll[a].add(b);
        }
        if(isCyclic(ll,n))
            return false;
        else
            return true;
        
    }
    public boolean Cycle(int i,LinkedList ll[],boolean visited[],boolean re[])
    {
        if(re[i])
            return true;
        if(visited[i])
            return false;
        visited[i]=true;
        re[i]=true;
        Iterator<Integer> itr=ll[i].iterator();
        while(itr.hasNext())
        {
            int b=itr.next();
            if(Cycle(b,ll,visited,re))
                return true;
        }
        re[i]=false;
        return false;
    }
    public boolean isCyclic(LinkedList ll[],int n)
    {
        boolean visited[]=new boolean[n];
        boolean re[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(Cycle(i,ll,visited,re))
            {
                return true;
            }
            
        }
        return false;
    }
}
