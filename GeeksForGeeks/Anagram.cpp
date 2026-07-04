class Solution {
  public:
    bool areAnagrams(string& s1, string& s2) {
        // code here
        unordered_map<char,int> maps;
        unordered_map<char,int> mapt;
        for(char c:s1){
            maps[c]++;
        }
        for(char c:s2){
            mapt[c]++;
        }
        if(maps==mapt){
            return true;
        }else{
            return false;
        }
        
    }
};