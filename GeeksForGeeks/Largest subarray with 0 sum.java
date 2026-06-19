class Solution {
    int maxLength(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for(int i = 0; i<arr.length; i++){
            prefixSum += arr[i];
            if(map.containsKey(prefixSum - 0)){
                int ind = map.get(prefixSum-0);
                maxLen = Math.max(maxLen, i-ind);
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }
        return maxLen;
        
    }
}