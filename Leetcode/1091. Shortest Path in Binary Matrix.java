class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        if(n == 1) return 1;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0,0});
        int dx[] = {-1,-1,-1,  0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1,-1, 0, 1};
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int[] curr = q.poll();
                for(int j = 0;  j<8; j++){
                    int ni = dx[j] + curr[0];
                    int nj = dy[j] + curr[1];

                    if(ni==n-1 && nj== n-1){
                        return count+1;
                    }

                    if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj]==0 && visited[ni][nj]==false){
                        visited[ni][nj]=true;
                        q.add(new int[]{ni,nj});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}