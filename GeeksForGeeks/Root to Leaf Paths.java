/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        recur(root, list, temp);
        return list;
    }
    void recur(Node node, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp){
        if (node == null) {
            return;
        }
        temp.add(node.data);
        if (node.left == null && node.right == null) {
            list.add(new ArrayList<>(temp));
        } else {
            recur(node.left, list, temp);
            recur(node.right, list, temp);
        }
        temp.remove(temp.size() - 1);
    }
}