/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 */

/*
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
