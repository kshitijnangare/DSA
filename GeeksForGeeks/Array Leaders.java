class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int maxRight = arr[n-1];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(maxRight);
        for(int i = n-2; i>=0; i--){
            if(arr[i]>=maxRight){
                res.add(arr[i]);
                maxRight = arr[i];
            }
        }
        Collections.reverse(res);
        return res;
    }
}
