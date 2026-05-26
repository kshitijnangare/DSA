class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    int findMaxArea(int[][] grid) {
        // code here
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    int temp = helper(grid, visited, new Pair(i,j), row, col);
                    count = Math.max(count, temp);
                }
            }
        }
        return count;
    }
    
    int helper(int grid[][], boolean[][] visited, Pair p, int row, int col){
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        int[] rc = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cc = {-1, 0, 1, -1, 1, -1, 0, 1};
        int count  = 1;
        visited[p.i][p.j] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            for(int k = 0; k<8; k++){
                int ni = i+rc[k];
                int nj = j+cc[k];
                if(ni>=0 && ni<row && nj>=0 && nj<col && visited[ni][nj]==false && grid[ni][nj]==1){
                    visited[ni][nj]=true;
                    count++;
                    q.add(new Pair(ni,nj));
                }
            }
        }
        return count;
    }
};