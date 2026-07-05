class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(), strs.end());
        int f = 0;
        int l = strs.size()-1;
        int fi = 0;
        int li=0;
        int fn= strs[f].size();
        int ln= strs[l].size();
        int count = 0;

        while(fi<fn && li<ln){
            if(strs[f][fi]==strs[l][li]){
                count++;
            }else{
                break;
            }
            fi++;
            li++;
        }
        string s = strs[f].substr(0, count);
        return s;
    }
};