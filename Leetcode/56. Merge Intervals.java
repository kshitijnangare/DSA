class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
        return a[0] < b[0];
    });

    vector<vector<int>> res;
    int n = intervals.size();
    vector<int> range = intervals[0]; 
    
    for (int i = 1; i < n; i++) {
        int prev1 = range[0];
        int next1 = range[1];
        int prev2 = intervals[i][0];
        int next2 = intervals[i][1];
        
        if (next1 < prev2) {
    
            res.push_back({prev1, next1});
            range = intervals[i];
        } else {
            range[0] = min(prev1, prev2);
            range[1] = max(next1, next2);
        }
    }
    res.push_back({range[0], range[1]});
    return res;
    }
};