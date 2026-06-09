class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        int n = seats.length;
        int total = 0;
        for(int i = 1; i<n; i++){
            if(seats[i]==seats[i-1] && seats[i]==1){return false;}
        }
        
        for(int i = 0; i<n; i++){
            int prev = i>0 ? seats[i-1] : 0;
            int next = i<n-1 ? seats[i+1] : 0;
            
            if(prev+next+seats[i] == 0){
                total++;
                i++;
            }
        }
        return total>=k;
    }
}