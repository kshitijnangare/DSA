class Solution {
    // recursion
    // static int countWays(String s) {
    //     // code here
    //     return recur(0, s.length()-1, true, s);
    // }
    // static int recur(int i, int j, boolean isTrue, String s){
    //     if(i>j){
    //         return 0;
    //     }
        
    //     if(i==j){
    //         if(isTrue){
    //             if(s.charAt(i)=='T'){
    //                 return 1;
    //             }else{
    //                 return 0;
    //             }
    //         }else{
    //             if(s.charAt(i)=='F'){
    //                 return 1;
    //             }else{
    //                 return 0;
    //             }
    //         }
    //     }
        
    //     int ways = 0;
    //     for(int k = i+1; k<j; k=k+2){
    //         int leftTrues = recur(i, k-1, true, s);
    //         int leftFalse = recur(i, k-1, false, s);
    //         int rightTrues = recur(k+1, j, true, s);
    //         int rightFalse = recur(k+1, j, false, s);
    //         if(s.charAt(k)=='&'){
    //             if(isTrue){
    //                 ways+= leftTrues * rightTrues;
    //             }else{
    //                 ways+= (leftFalse*rightTrues) + (leftTrues*rightFalse) + (leftFalse*rightFalse);
    //             }
    //         }else if(s.charAt(k)=='|'){
    //             if(isTrue){
    //                 ways+= (leftTrues*rightFalse) + (leftTrues*rightTrues) + (leftFalse*rightTrues);
    //             }else{
    //                 ways+= leftFalse * rightFalse;
    //             }
    //         }else{
    //             if(isTrue){
    //                 ways+= (leftTrues*rightFalse)+(leftFalse*rightTrues);
    //             }else{
    //                 ways+= (leftTrues*rightTrues) + (leftFalse*rightFalse);
    //             }
    //         }
    //     }
    //     return ways;
    // }
    
    
    // memoization
    // static int countWays(String s) {
    //     // code here
    //     int n = s.length();
    //     int[][][] dp = new int[n][n][2];
    //     for(int[][] r1: dp ){
    //         for(int[] r2: r1){
    //             Arrays.fill(r2, -1);
    //         }
    //     }
        
    //     return recur(0, s.length()-1, 1, s, dp);
    // }
    // static int recur(int i, int j, int isTrue, String s, int[][][] dp){
    //     if(i>j){
    //         return 0;
    //     }
        
    //     if(i==j){
    //         if(isTrue==1){
    //             if(s.charAt(i)=='T'){
    //                 return 1;
    //             }else{
    //                 return 0;
    //             }
    //         }else{
    //             if(s.charAt(i)=='F'){
    //                 return 1;
    //             }else{
    //                 return 0;
    //             }
    //         }
    //     }
        
    //     if(dp[i][j][isTrue]!=-1){
    //         return dp[i][j][isTrue];
    //     }
        
    //     int ways = 0;
    //     for(int k = i+1; k<j; k=k+2){
    //         int leftTrues = recur(i, k-1, 1, s, dp);
    //         int leftFalse = recur(i, k-1, 0, s, dp);
    //         int rightTrues = recur(k+1, j, 1, s, dp);
    //         int rightFalse = recur(k+1, j, 0, s, dp);
    //         if(s.charAt(k)=='&'){
    //             if(isTrue==1){
    //                 ways+= leftTrues * rightTrues;
    //             }else{
    //                 ways+= (leftFalse*rightTrues) + (leftTrues*rightFalse) + (leftFalse*rightFalse);
    //             }
    //         }else if(s.charAt(k)=='|'){
    //             if(isTrue==1){
    //                 ways+= (leftTrues*rightFalse) + (leftTrues*rightTrues) + (leftFalse*rightTrues);
    //             }else{
    //                 ways+= leftFalse * rightFalse;
    //             }
    //         }else{
    //             if(isTrue==1){
    //                 ways+= (leftTrues*rightFalse)+(leftFalse*rightTrues);
    //             }else{
    //                 ways+= (leftTrues*rightTrues) + (leftFalse*rightFalse);
    //             }
    //         }
    //     }
    //     return dp[i][j][isTrue]=ways;
    // }
    
    
    // tabultaion
    static int countWays(String s) {
        // code here
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        
        for(int j = 0; j<n; j++){
            for(int i = n-1; i>j; i--){
                for(int k = 0; k<2; k++){
                    dp[i][j][k]=0;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int k = 0; k<2; k++){
                if(k==1){
                    if(s.charAt(i)=='T'){
                        dp[i][i][k]=1;
                    }else{
                        dp[i][i][k]=0;
                    }
                }else{
                    if(s.charAt(i)=='F'){
                        dp[i][i][k]=1;
                    }else{
                        dp[i][i][k]=0;
                    }
                }
            }
        }
        
        for(int i =n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                for(int isTrue = 0; isTrue<2; isTrue++){
                    int ways = 0;
                    for(int z = i+1; z<j; z=z+2){
                        int leftTrues = dp[i][z-1][1];
                        int leftFalse = dp[i][z-1][0];
                        int rightTrues = dp[z+1][j][1];
                        int rightFalse = dp[z+1][j][0];
                        if(s.charAt(z)=='&'){
                            if(isTrue==1){
                                ways+= leftTrues * rightTrues;
                            }else{
                                ways+= (leftFalse*rightTrues) + (leftTrues*rightFalse) + (leftFalse*rightFalse);
                            }
                        }else if(s.charAt(z)=='|'){
                            if(isTrue==1){
                                ways+= (leftTrues*rightFalse) + (leftTrues*rightTrues) + (leftFalse*rightTrues);
                            }else{
                                ways+= leftFalse * rightFalse;
                            }
                        }else{
                            if(isTrue==1){
                                ways+= (leftTrues*rightFalse)+(leftFalse*rightTrues);
                            }else{
                                ways+= (leftTrues*rightTrues) + (leftFalse*rightFalse);
                            }
                        }
                    }
                    dp[i][j][isTrue]=ways;
                }
            }
        }
        
        return dp[0][s.length()-1][1];
    }
}