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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recur(root);
        return maxSum;
    }
    int recur(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftSum = recur(node.left);
        int rightSum = recur(node.right);

        int leftEffective = Math.max(0, leftSum);
        int rightEffective = Math.max(0, rightSum);

        maxSum = Math.max(maxSum, node.val+leftEffective+rightEffective);
        return node.val + Math.max(leftEffective, rightEffective);
    }
}