import java.util.*;
public class Solution {
    public static int minimumTimeTakingPath(int[][] heights){
        // Write your code here.
        int row = heights.length;
        int col = heights[0].length;
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[row][col];
        for(int[] r: dist){
            Arrays.fill(r, INF);
        }

        dist[0][0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->Integer.compare(a[2], b[2]) );
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int i = arr[0];
            int j = arr[1];
            int wt = arr[2];

            if(wt>dist[i][j]){
                continue;
            }

            for(int z = 0; z<4; z++){
                int ni = i + dx[z];
                int nj = j + dy[z];

                if(ni>=0 && ni<row && nj>=0 && nj<col){
                    int absdiff = Math.abs(heights[i][j]-heights[ni][nj]);
                    int newEffort = Math.max(wt, absdiff);
                    if(dist[ni][nj]>newEffort){
                        dist[ni][nj]=newEffort;
                        pq.add(new int[]{ni,nj, newEffort});
                    }
                }
            }

        }
        return dist[row-1][col-1];
    }
}
