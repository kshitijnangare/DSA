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
    public TreeNode searchBST(TreeNode root, int val) {
        return recur(root, val);
    }
    TreeNode recur(TreeNode node, int val){
        if(node == null){
            return null;
        }
        if(node.val == val){
            return node;
        }
        if(val<node.val){
            return recur(node.left, val);
        }else{
            return recur(node.right, val);
        }
    }
}