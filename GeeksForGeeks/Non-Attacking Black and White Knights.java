class Solution {
    public int numOfWays(int n, int m) {
        // code here
        int[] ic = {-1,-1,-2,-2,+1,+1,+2,+2};
        int[] jc = {-2,+2,-1,+1,-2,+2,-1,+1};
        
        int totalgrid = n*m-1;
        int total = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int minusCount=0;
                for(int k = 0; k<8; k++){
                    int ni = i+ic[k];
                    int nj = j+jc[k];
                    if(ni>=0 && ni<n && nj>=0 && nj<m){
                        minusCount++;
                    }
                }
                total = total+totalgrid-minusCount;
            }
        }
        return total;
    }
}