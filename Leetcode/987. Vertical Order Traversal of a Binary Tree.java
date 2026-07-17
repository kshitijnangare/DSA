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
    int hd;
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd=hd;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){return list;}

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer, List<Integer>> temp = new HashMap<>();
            for(int i = 0; i<size; i++){
                Pair p =q.poll();
                int hd = p.hd;
                TreeNode curr = p.node;
                temp.computeIfAbsent(hd, k->new ArrayList<Integer>()).add(curr.val);
                if(curr.left!=null){
                    q.add(new Pair(curr.left, hd-1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right, hd+1));
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : temp.entrySet()) {
                int hd = entry.getKey();
                List<Integer> values = entry.getValue();
                Collections.sort(values);
                
                map.computeIfAbsent(hd, k -> new ArrayList<>()).addAll(values);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }
}