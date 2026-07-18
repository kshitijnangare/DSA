class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        int[] order = new int[numCourses];
        int ind = 0;
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0; i<prerequisites.length; i++){
            int f = prerequisites[i][0];
            int s = prerequisites[i][1];
            adj.get(s).add(f);
            indegree[f]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
                order[ind++]=i;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int x: adj.get(curr)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.add(x);
                    order[ind++]=x;
                }
            }
        }
        if (ind != numCourses) {
            return new int[0];
        }
        return order;
    }
}