class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int noOfNode = adj.size();
        boolean visited[] = new boolean[noOfNode+1];
        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.add(0);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int x: adj.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                    list.add(x);
                }
            }
        }
        return list;
    }
}