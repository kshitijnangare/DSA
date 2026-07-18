class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        boolean ans= true;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                ans = ans && bfs(i, color, visited, graph);
            }
            if(ans==false){return false;}
        }
        return ans;
    }
    boolean bfs(int s, int[] color, boolean[] visited, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s]=true;
        color[s]=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int curr = q.poll();
                int currcolor = color[curr];
                for(int x: graph[curr]){
                    if(visited[x]==false && color[x]==-1){
                        color[x]= currcolor^1;
                        visited[x]=true;
                        q.add(x);
                    }else{
                        if(color[x]==currcolor){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}