/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }        
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode LCA1 = lowestCommonAncestor(root.left, p, q);
        TreeNode LCA2 = lowestCommonAncestor(root.right, p, q);

        if(LCA1!=null && LCA2!=null){
            return root;
        }
        if(LCA1!=null){
            return LCA1;
        }else{
            return LCA2;
        }
    }
}