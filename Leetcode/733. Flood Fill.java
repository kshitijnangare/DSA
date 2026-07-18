class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int ogcolor = image[sr][sc];
        if(ogcolor ==color){return image;}

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        q.add(new int[]{sr,sc});
        visited[sr][sc]=true;
        image[sr][sc]=color;
        int[] rc = {-1,0,1,0};
        int[] cc = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i=curr[0];
            int j = curr[1];
            for(int k = 0; k<4; k++){
                int ni = i + rc[k];
                int nj = j + cc[k];
                if(ni>=0 && nj>=0 && ni<row && nj<col && !visited[ni][nj] && image[ni][nj]==ogcolor){
                    visited[ni][nj]=true;
                    image[ni][nj]=color;
                    q.add(new int[]{ni,nj});
                }
            }
        }
        return image;
    }
}