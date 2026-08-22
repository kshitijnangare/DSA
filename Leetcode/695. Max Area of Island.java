class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    int area = helper(i, j, grid, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    public int helper(int i, int j, int[][] grid, boolean[][] visited){
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        int row = grid.length;
        int col = grid[0].length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int k = 0; k<4; k++){
                int ni = curr[0]+dx[k];
                int nj = curr[1]+dy[k];

                if(ni>=0 && ni<row && nj>=0 && nj<col && visited[ni][nj]==false && grid[ni][nj]==1){
                    area+=1;
                    q.add(new int[]{ni,nj});
                    visited[ni][nj]=true;
                }
            }
        }
        return area;
    }
}