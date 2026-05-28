/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // code here
        // I will use this hashmap to store the horizontal distance from root and 
        // sum of numbers on that horizontal distance.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, map, 0);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
    
    public void helper(Node root, TreeMap<Integer, Integer> map, int horizontalDist){
        if(root==null){return;}
        helper(root.left, map, horizontalDist-1);
        helper(root.right, map, horizontalDist+1);
        map.put(horizontalDist, map.getOrDefault(horizontalDist, 0)+root.data);
    }
}