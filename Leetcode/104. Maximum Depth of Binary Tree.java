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
    public int maxDepth(TreeNode root) {
        return recur(root);
    }
    int recur(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int leftDepth = 1 + recur(root.left);
            int rightDepth = 1 + recur(root.right);
            return Math.max(leftDepth, rightDepth);
        }
    }
}