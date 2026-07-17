/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/
class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node = node;
        this.hd=hd;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root==null){return list;}

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p =q.poll();
            int hd = p.hd;
            Node curr = p.node;
            map.computeIfAbsent(hd, k->new ArrayList<Integer>()).add(curr.data);
            if(curr.left!=null){
                q.add(new Pair(curr.left, hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right, hd+1));
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }
}


