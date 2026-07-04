class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char,int> maps;
        unordered_map<char,int> mapt;
        for(char c:s){
            maps[c]++;
        }
        for(char c:t){
            mapt[c]++;
        }
        if(maps==mapt){
            return true;
        }else{
            return false;
        }
    }
};