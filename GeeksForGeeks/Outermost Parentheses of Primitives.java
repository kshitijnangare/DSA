class Solution {
    public String removeOuter(String s) {
        // code here
        int opened = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                if(opened>0){
                    sb.append("(");
                }
                opened++;
            }else{
                opened--;
                if(opened>0){
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }
}