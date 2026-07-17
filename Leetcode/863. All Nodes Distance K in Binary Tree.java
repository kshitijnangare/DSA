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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null){
            return new ArrayList<>();
        }
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        fillerMap(root, map);
        return bfs(target, map, k);

    }
    void fillerMap(TreeNode node, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    List<Integer> bfs(TreeNode target, HashMap<TreeNode, TreeNode> map, int k ){
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        q.add(target);
        set.add(target);
        int currdist = 0;
        while(!q.isEmpty()){
            if(currdist++ == k){
                break;
            }
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left!=null && !set.contains(curr.left)){
                    set.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right != null && !set.contains(curr.right)){
                    set.add(curr.right);
                    q.add(curr.right);
                }

                if(map.containsKey(curr) && !set.contains(map.get(curr))){
                    TreeNode val = map.get(curr);
                    set.add(val);
                    q.add(val);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }
        return res;
    }
}