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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recur(p, q);
    }
    boolean recur(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null){
            return false;
        }
        if(q==null){
            return false;
        }
        if(q.val!=p.val){
            return false;
        }
        boolean left = recur(p.left, q.left);
        boolean right = recur(p.right, q.right);
        return left && right;
    }
}