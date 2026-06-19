class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int count = 0;
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i<n; i++){
            int lz = 0;
            int rz = 0;
            int tz = 0;
            boolean leftOne = false;
            boolean rightOne = false;
            int left = 0; int right = m-1;
            while(left<m){
                if(mat[i][left]==0 && leftOne==false){
                    lz++;
                }
                if(mat[i][left]==1 && leftOne==false){
                    leftOne=true;
                }
                if(mat[i][right]==0 && rightOne==false){
                    rz++;
                }
                if(mat[i][right]==1 && rightOne==false){
                    rightOne=true;
                }
                
                if(mat[i][left]==0){
                    tz++;
                }
                
                left++;
                right--;
            }
            count = count + (tz-lz) + (tz-rz);
        }
        
        
        for(int j = 0; j<m; j++){
            int topz = 0;
            int bottomz = 0;
            int tz = 0;
            boolean topOne = false;
            boolean bottomOne = false;
            int top = 0; int bottom = n-1;
            while(top<n){
                if(mat[top][j]==0 && topOne==false){
                    topz++;
                }
                if(mat[top][j]==1 && topOne==false){
                    topOne=true;
                }
                if(mat[bottom][j]==0 && bottomOne==false){
                    bottomz++;
                }
                if(mat[bottom][j]==1 && bottomOne==false){
                    bottomOne=true;
                }
                
                if(mat[top][j]==0){
                    tz++;
                }

                top++;
                bottom--;
            }
            count = count + (tz-topz) + (tz-bottomz);
        }
        return count;
        
    }
}