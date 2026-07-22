/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        int res = -1;
        while(root!=null){
            int data = root.data;
            if(data==k){
                return data;
            }else if(data > k){
                root=root.left;
            }else{
                res = root.data;
                root = root.right;
            }
        }
        return res;
    }
}