class Solution {
	int shortestPath(int[][] mat) {
		// code here
		int steps = 0;
		int row = mat.length;
		int col = mat[0].length;
		
		boolean[][] visited = new boolean[row][col];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				if (mat[i][j] == 0) {
					for (int k=0; k<4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if (ni >= 0 && ni<row && nj >= 0 && nj<col) {
							visited[ni][nj] = true;
						}
					}
					visited[i][j]=true;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i<row; i++) {
			if (visited[i][0] == false) {
				q.add(new int[] {i, 0});
				visited[i][0] = true;
			}
		}
		
		while (!q.isEmpty()) {
			steps++;
			int size = q.size();
			for (int z = 0; z<size; z++) {
				int i = q.peek()[0];
				int j = q.peek()[1];
				q.poll();
				for (int k=0; k<4; k++) {
					int ni = i + dx[k];
					int nj = j + dy[k];
					if(ni >= 0 && ni<row && nj >= 0 && nj<col && mat[ni][nj]!=0 && visited[ni][nj]==false){
						if(nj==col-1){
					    	return steps+1;
					    }
						visited[ni][nj] = true;
						q.add(new int[]{ni,nj});
					}
				}
			}
		}
		return -1;
	}
}
