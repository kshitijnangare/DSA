class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    q.add(new int[]{i,j,-1,-1});
                    visited[i][j]=true;
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        int perimeter = 4;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int parenti = curr[2];
            int parentj = curr[3];
            for(int i = 0; i<4; i++){
                int ni = curr[0]+dx[i];
                int nj = curr[1]+dy[i];
                if(ni>=0 && ni<row && nj>=0 && nj<col && grid[ni][nj]==1){
                    if(visited[ni][nj]==false){
                        perimeter+=2;
                        q.add(new int[]{ni,nj, curr[0], curr[1]});
                        visited[ni][nj]=true;
                    }else if(ni!=parenti && nj!=parentj){
                        perimeter-=1;
                    }
                }
            }
        }
        return perimeter;
    }
}