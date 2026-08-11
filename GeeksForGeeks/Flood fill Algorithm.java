class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];
        
        int ogclr = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]=newColor;
        visited[sr][sc]=true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            int curri = q.peek()[0];
            int currj = q.peek()[1];
            q.poll();
            for(int i = 0; i<4; i++){
                int ni = curri+dx[i];
                int nj = currj+dy[i];
                
                if(ni>=0 && ni<row && nj>=0 && nj<col && !visited[ni][nj] && image[ni][nj]==ogclr){
                    image[ni][nj]=newColor;
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        }
        return image;
    }
}