class Five{
    int i;
    int j;
    int mask;
    int energy;
    int steps;

    public Five(int f, int s, int t, int fo, int fi){
        i = f;
        j = s;
        mask = t;
        energy = fo;
        steps = fi;
    }
}
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int row = classroom.length;
        int col = classroom[0].length();

        int[][] Lcount = new int[row][col];
        for(int[] rows: Lcount){
            Arrays.fill(rows, -1);
        }
        int count = 0;
        int si = 0;
        int sj = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                char c= classroom[i].charAt(j);
                if(c=='L'){
                    Lcount[i][j]= count++;
                }
                if(c == 'S'){
                    si = i;
                    sj = j;
                }
            }
        }
        int totalMask = (1 << count) -1;

        int[][][] maxEnergy = new int[row][col][1 << count];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }

        Queue<Five> q= new LinkedList<>();
        q.add(new Five(si, sj, 0, energy, 0));
        maxEnergy[si][sj][0] = energy;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        while(!q.isEmpty()){
            Five curr = q.poll();

            if(curr.mask == totalMask){
                return curr.steps;
            }
            if(curr.energy == 0) {
                continue;
            }

            for(int k = 0; k<4; k++){
                int ni = curr.i + dx[k];
                int nj = curr.j + dy[k];

                if(ni>=0 && ni<row && nj>=0 && nj<col){
                    char c = classroom[ni].charAt(nj);
                    
                    if(c=='X'){
                        continue;
                    }

                    int nEnergy = curr.energy - 1;
                    int nMask = curr.mask;

                    if(c == 'R'){
                        nEnergy = energy;
                    }else if(c == 'L'){
                        int shift = Lcount[ni][nj];
                        nMask = (curr.mask | (1<<shift));
                    }
                    if (nEnergy > maxEnergy[ni][nj][nMask]) {
                        maxEnergy[ni][nj][nMask] = nEnergy;
                        q.add(new Five(ni, nj, nMask, nEnergy, curr.steps + 1));
                    }
                }
            }
        }
        return -1;
    }
}