/*Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int x=1;x<=n;x++)
        {
            dp[x][0]=dp[x-1][0]+1;
        }
        for(int y=1;y<=m;y++)
        {
            dp[0][y]=dp[0][y-1]+1;
        }
        for(int x=1;x<=n;x++)
        {
            for(int y=1;y<=m;y++)
            {
                if(word1.charAt(x-1)==word2.charAt(y-1))
                {
                    dp[x][y]=dp[x-1][y-1];
                }
                else
                {
                    dp[x][y]=1+Math.min(dp[x][y-1],Math.min(dp[x-1][y-1],dp[x-1][y]));
                }
            }
        }
        return dp[n][m];
        
    }
}
