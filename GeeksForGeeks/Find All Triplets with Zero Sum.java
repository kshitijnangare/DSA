// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int val = -1 * (arr[i]+arr[j]);
                if(map.containsKey(val)){
                    for (int k : map.get(val)) {
                        res.add(Arrays.asList(k, i, j));
                    }
                }
            }
            
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        return res;
    }
}