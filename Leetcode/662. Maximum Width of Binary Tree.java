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
class Pair{
    TreeNode node;
    int i;
    Pair(TreeNode node, int i){
        this.node = node;
        this.i = i;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if(root==null){return 0;}
        q.add(new Pair(root, 1));
        int maxwidth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int currwidth = 0;
            int mini = Integer.MAX_VALUE;
            int maxi=-1;
            int levelmin = q.peek().i; 
            for(int i = 0; i<size; i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                int ind = p.i;
                mini=Math.min(mini, ind);
                maxi = Math.max(maxi, ind);
                if(curr.left!=null){
                    int indEff = ind-levelmin;
                    int lcind = indEff*2 +1;
                    q.add(new Pair(curr.left, lcind));
                }
                if(curr.right != null){
                    int indEff = ind-levelmin;
                    int rcind = indEff*2+2;
                    q.add(new Pair(curr.right, rcind));
                }
            }
            currwidth = maxi-mini+1;
            maxwidth = Math.max(maxwidth, currwidth);
        }
        return maxwidth;
    }
}