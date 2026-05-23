/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        // code here
        helper(root);
    }
    private int helper(Node node) {
        if(node == null) {
            return 0;
        }
        int oldVal = node.data;
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        node.data = leftSum + rightSum;
        return oldVal + node.data;
    }
}