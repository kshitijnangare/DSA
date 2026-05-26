class Solution {
    int minToggle(int[] arr) {
        // code here
        int totalZeros = 0;
        for(int x: arr){
            if(x==0){totalZeros++;}
        }
        int count = totalZeros;
        int leftOnes = 0;
        int rightZeros = totalZeros;
        for(int x: arr){
            if(x==0){
                rightZeros--;
            }else{
                leftOnes++;
            }
            int curr = rightZeros+leftOnes;
            count = Math.min(count, curr);
        }
        return count;
    }
}