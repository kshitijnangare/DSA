/*Complete the function below*/
class Node{
    int s;
    int l;
    Node(int s, int l){
        this.s = s;
        this.l = l;
    }
}
class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // code here
        int e = adj.size();
        int level = -1;
        int s = 0;
        if(s==X){
            return level;
        }
        boolean[] visited = new boolean[V+1];
        visited[s] = true;
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(s, 0));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int cs = curr.s;
            int cl = curr.l;
            if(cs == X){
                level = cl;
                break;
            }
            int nl = cl+1;
            for(int i: adj.get(cs)){
                if(visited[i] == false){
                    q.add(new Node(i, nl));
                    visited[i] = true;
                }
            }
        }
        return level;
    }
}