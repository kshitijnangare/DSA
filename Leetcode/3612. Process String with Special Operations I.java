class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '#':
                    if(sb.length()!=0 ){
                        sb.append(sb);
                    } 
                    break;
                case '%':
                    if(sb.length()!=0 ){
                        sb.reverse();
                    }
                    break;
                case '*':
                    if(sb.length()!=0 ){
                        sb.deleteCharAt(sb.length()-1);
                    }
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }
}