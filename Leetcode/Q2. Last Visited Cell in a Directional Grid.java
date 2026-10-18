class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int i = 0;
        int j = 0;
        int lasti = 0;
        int lastj = 0;

        while(i>=0 && i<row && j>=0 && j<col && visited[i][j]==false){
            visited[i][j]=true;
            char c = grid[i][j];
            lasti = i;
            lastj = j;
            switch(c){
                case 'L':
                    j = j-1;
                    break;
                case 'R':
                    j = j+1;
                    break;
                case 'U':
                    i = i-1;
                    break;
                case 'D':
                    i = i+1;
                    break;
            }
            
        }
        return new int[]{lasti,lastj};
    }
}