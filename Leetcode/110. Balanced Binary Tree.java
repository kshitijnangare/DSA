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
    public boolean isBalanced(TreeNode root) {
        int res = recur(root);
        if(res == -1){
            return false;
        }
        return true;
    }
    int recur(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftH = recur(root.left);
        if(leftH == -1){
            return -1;
        }
        int rightH = recur(root.right);
        if(rightH == -1){
            return -1;
        }

        int diff = Math.abs(rightH-leftH);
        if(diff>1){
            return -1;
        }

        return 1 + Math.max(leftH, rightH);
    }
}