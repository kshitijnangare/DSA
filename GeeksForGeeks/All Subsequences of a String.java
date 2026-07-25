class Solution {
    public List<String> powerSet(String s) {
        // Code here
        int n = s.length();
        int psize = (1<<n);
        List<String> res = new ArrayList<>();
        for(int i = 0; i<psize; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                if((i & (1<<j)) !=0){
                    sb.append(s.charAt(j));
                }
            }
            res.add(sb.toString());
        }
        Collections.sort(res);
        return res;
    }
}