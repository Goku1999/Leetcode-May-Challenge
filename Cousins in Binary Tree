/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        return !sameParent(root,x,y)&&(level(root,x,0)==level(root,y,0));
        /*System.out.println(!sameParent(root,x,y));
        System.out.println(level(root,x,0));
        System.out.println(level(root,y,0));
        return true;*/
    }
    public boolean sameParent(TreeNode root, int x, int y)
    {
        if(root==null)
        {
            return false;
        }
        else
        {
            if(root.val==x||root.val==y)
            {
                return false;
            }
            if(root.left==null)
            {
                return sameParent(root.right,x,y);
            }
            if(root.right==null)
            {
                return sameParent(root.left,x,y);
            }
            if(root.left.val==x&&root.right.val==y||root.left.val==y&&root.right.val==x)
            {
                return true;
            }
            return sameParent(root.left,x,y)||sameParent(root.right,x,y);
        }
    }
    public int level(TreeNode root,int x,int level)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.val==x)
        {
            return level;
        }
        else
        {
            int d=level(root.left,x,level+1);
            if(d!=0)
            {
                return d;    
            }
            d=level(root.right,x,level+1);
            return d;
        }
    }
}
