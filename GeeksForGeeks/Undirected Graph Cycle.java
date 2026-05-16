class Node{
    int f;
    int s;
    Node(int f, int s){
        this.f = f;
        this.s = s;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<V; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            list.get(f).add(s);
            list.get(s).add(f);
        }
        
        boolean[] visited = new boolean[V];
        for(int i = 0; i<V; i++){
            if(visited[i] == false){
                if (helper(list, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean helper(ArrayList<ArrayList<Integer>> list, boolean[] visited, int start){
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(start,-1));
        visited[start] = true;
        
        boolean ans = false;
        
        while(!q.isEmpty()){
            int curr = q.peek().f;
            int parent = q.peek().s;
            q.remove();
            
            for(int v: list.get(curr)){
                if(v==parent){
                    continue;
                }
                if(visited[v] == true){
                    ans = true;
                    break;
                }else{
                    q.add(new Node(v, curr));
                    visited[v] = true;
                }
            }
        }
        return ans;
    }
}