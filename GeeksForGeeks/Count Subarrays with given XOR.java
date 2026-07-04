class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1); 
        int prefiXor = 0;
        for(int i = 0; i<arr.length; i++){
            prefiXor = prefiXor ^ arr[i];
            if(map.containsKey(prefiXor ^ k)){
                res = res + map.get(prefiXor ^ k);
            }
            map.put(prefiXor, map.getOrDefault(prefiXor, 0)+1);
        }
        return res;
    }
}