class Solution {
  public:
    bool areIsomorphic(string &s1, string &s2) {
        // code here
        int n1 = s1.size();
        int n2 = s2.size();
        if(n1!=n2){return false;}
        
        unordered_map<char, char> maps1;
        unordered_set<char> sets2;
        int i = 0;
        while(i<n1){
            char c1 = s1[i];
            char c2 = s2[i];
            if(maps1.count(c1)==1){
                char mapped = maps1[c1];
                if(mapped!=c2){
                    return false;
                }
            }else{
                if(sets2.count(c2)==1){
                    return false;
                }
            }
            maps1[c1]=c2;
            sets2.insert(c2);
            i++;
        }
        return true;
    
    }
};