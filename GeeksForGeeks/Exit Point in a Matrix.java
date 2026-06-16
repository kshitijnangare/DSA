class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        int i = 0; 
        int j = 0;
        int[] dir = {0,1};
        int previ = 0; int prevj = 0;
        while(i<row && j<col && i>=0 && j>=0){
            previ = i;
            prevj = j;
            if(mat[i][j]==0){
                i = i+dir[0];
                j = j+dir[1];
            }else{
                if(dir[0]==0 && dir[1]==1){
                    dir[0]=1; dir[1]=0;
                }else if(dir[0]==1 && dir[1]==0){
                    dir[0]=0; dir[1]=-1;
                }else if(dir[0]==0 && dir[1]==-1){
                    dir[0]=-1; dir[1]=0;
                }else{
                    dir[0]=0; dir[1]=1;
                }
                mat[i][j] = 0;
                i = i+dir[0];
                j = j+dir[1];
            }
        }

        return List.of(previ, prevj);
    }
}