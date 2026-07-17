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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        s1.push(root);
        while(!s1.empty() || !s2.empty()){
            List<Integer> temp = new ArrayList<>();
            while(!s1.empty()){
                TreeNode curr = s1.pop();
                temp.add(curr.val); 
                if(curr.left!=null){
                    s2.push(curr.left);
                }
                if(curr.right!=null){
                    s2.push(curr.right);
                }
            }
            if(temp.size()!=0) list.add(temp);
            temp = new ArrayList<>();
            while(!s2.empty()){
                TreeNode curr = s2.pop();
                temp.add(curr.val);
                if(curr.right!=null){
                    s1.push(curr.right);
                }
                if(curr.left!=null){
                    s1.push(curr.left);
                }
            }
            if(temp.size()!=0) list.add(temp);
        }
        return list;
    }
}