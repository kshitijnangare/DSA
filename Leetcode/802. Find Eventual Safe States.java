class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<graph[i].length; j++){
                int s = graph[i][j];
                int f = i;
                adj.get(s).add(f);
            }
            indegree[i]=graph[i].length;
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
                res.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int x: adj.get(curr)){
                indegree[x]--;
                if(indegree[x]==0){
                    res.add(x);
                    q.add(x);
                }
            }
        }
        Collections.sort(res);
        return res;

    }
}