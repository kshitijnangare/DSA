class Solution {
public:
    string removeOuterParentheses(string s) {
        int len = s.size();
        string res = "";
        int opened = 0;
        for(char c: s){
            if(c=='('){
                if(opened>0){
                    res = res + "(";
                }
                opened++;
            }else{
                opened--;
                if(opened>0){
                    res = res + ")";
                }
            }
        }
        return res;
    }
};