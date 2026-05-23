class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        // Code here
        int n = arr.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i], i);
        }
        
        Arrays.sort(arr);
        
        int swaps = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(visited[i] == true || map.get(arr[i]) == i){
                continue;
            }
            
            int j = i;
            int cycles = 0;
            while(visited[j] == false){
                visited[j] = true;
                j = map.get(arr[j]);
                cycles++;
            }
            
            if(cycles>0){
                swaps = swaps+cycles-1;
            }
        }
        return swaps;
    }
}