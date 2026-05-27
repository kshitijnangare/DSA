class Solution {
    public boolean wifiRange(String s, int x) {
        // code here
        
        // My method with Time: O(n) and Space: O(n)
        // int len = s.length();
        // int[] visited = new int[len];
        // int currConsecutiveZeros = x;
        // if(len==1){
        //     if(s.charAt(0)=='0'){
        //         return false;
        //     }else{
        //         return true;
        //     }
        // }
        // for(int i = 0; i<len; i++){
        //     char curr = s.charAt(i);
        //     if (curr=='0'){
        //         if(currConsecutiveZeros<x){visited[i]=1;}
        //         currConsecutiveZeros++;
        //     }else{
        //         visited[i]=1;
        //         currConsecutiveZeros=0;
        //     }
        // }
        // currConsecutiveZeros = x;
        
        // for(int i =len-1; i>=0; i--){
        //     char curr = s.charAt(i);
        //     if (curr=='0'){
        //         if(currConsecutiveZeros<x){visited[i]=1;}
        //         currConsecutiveZeros++;
        //     }else{
        //         visited[i]=1;
        //         currConsecutiveZeros=0;
        //     }
        // }
        // for(int k: visited){
        //     if(k!=1){
        //         return false;
        //     }
        // }
        // return true;
        
        
        
        // Optimised approach with Time: O(n) & Space: O(1)
        int n = s.length();
        
        // Keeps track of the rightmost covered room
        int maxReach = -1; 

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {

                // If gap exists between previous
                // coverage and current WiFi
                if (maxReach < i - x - 1) {
                    return false;
                }

                // Update maximum reach
                maxReach = Math.max(maxReach, i + x);
            }
        }

        // Check if last position is covered
        return maxReach >= n - 1;
    }
}