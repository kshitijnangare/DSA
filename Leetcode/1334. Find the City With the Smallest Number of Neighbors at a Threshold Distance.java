class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        int inf = 100000000;
        for(int[] row : dist) {
            Arrays.fill(row, inf);
        }
        for(int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }


        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] != inf && dist[k][j] != inf) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); 
                    }
                }
            }
        }

        int ansnode = -1;
        int minconnected = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count <= minconnected) {
                minconnected = count;
                ansnode = i;
            }
        }
        return ansnode;
    }
}