class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        // Code here
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int[] row: dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
        
        dist[0][0] = grid[0][0];
        pq.add(new int[]{0, 0, grid[0][0]});
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];
            
            if(r==n-1 && c==n-1){
                return cost;
            }
            
            if(cost>dist[r][c]){
                continue;
            }
            
            for(int i = 0; i<4; i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n){
                    if(cost+grid[nRow][nCol]<dist[nRow][nCol]){
                        dist[nRow][nCol] = cost + grid[nRow][nCol];
                        pq.add(new int[]{nRow, nCol, dist[nRow][nCol]});
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}