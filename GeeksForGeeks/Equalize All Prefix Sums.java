class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int low = 0;
        list.add(0);
        for(int i = 1; i<n; i++){
            int mid = low + (i-low)/2;
            int prevEle = arr[mid];
            int newEle = arr[i];
            int diff = newEle - prevEle;
            int prevRes = list.get(i-1);
            int newRes = prevRes+diff;
            list.add(newRes);
        }
        return list;
    }
}