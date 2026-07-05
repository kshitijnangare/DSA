class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        unordered_map<int,int>::iterator it;
        for(int x:nums){
            m[x]++;
        }
        vector<pair<int,int> > v(m.begin(), m.end());
        sort(v.begin(), v.end(), [](const pair<int,int>& a, const pair<int,int>& b ){
            return b.second < a.second;
        });
        vector<int> res;
        for(int i = 0; i<k; i++){
            int sec = v[i].first;
            res.push_back(sec);
        }
        return res;
    }
};