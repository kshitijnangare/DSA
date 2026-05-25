class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int minPlatforms = 1;
        int trainsCount = 0;
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int indA = 0, indD = 0;
        while(indA<n){
            if(arr[indA]<=dep[indD]){
                trainsCount++;
                minPlatforms = Math.max(minPlatforms, trainsCount);
                indA++;
            }else{
                trainsCount--;
                indD++;
            }
        }
        return minPlatforms;
    }
}

// 900, 940,  950,  1100, 1500, 1800
// 910, 1120, 1130, 1200, 1900, 2000
