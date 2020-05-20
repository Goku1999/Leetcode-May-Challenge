/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.*/

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
    int ar[];
    int i;
    public int kthSmallest(TreeNode root, int k) 
    {
        int n=count(root);
        i=0;
        ar=new int[n];
        if(n==1)
        {
            return root.val;
        }
        find(root);    
        return ar[k-1];
    }
    public void find(TreeNode root)
    {
        if(root!=null)
        {
            find(root.left);
            ar[i++]=root.val;
            find(root.right);
        }
    }
    public int count(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            return 1+count(root.left)+count(root.right);
        }
    }
}
