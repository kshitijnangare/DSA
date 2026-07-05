class Solution {
public:
    int maxDepth(string s) {
        int maxi = 0;
        int curr = 0;
        for(char c : s){
            if(c=='('){
                curr++;
                maxi=max(maxi, curr);
            }else if(c==')'){
                curr--;
            }
        }
        return maxi;
    }
};