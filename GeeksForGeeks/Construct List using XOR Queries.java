class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int xor = 0;
        int n = queries.length;
        for(int i = n-1; i>=0; i--){
            int f = queries[i][0];
            int s= queries[i][1];
            if(f==0){
                list.add(s^xor);
            }else{
                xor = xor ^ s;
            }
        }
        list.add(xor);
        Collections.sort(list);
        return list;
    }
}