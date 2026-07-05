class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> s(nums.begin(), nums.end());

        int res = 0;

        for(int z: s){
            if(s.count(z-1)==0){
                int x = z;
                int count = 1;
                while(s.count(x+1)==1){
                    count++;
                    x=x+1;
                }
                res = max(count,res);
            }
        }
        return res;
    }
};