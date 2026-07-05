class Solution {
  public:
    vector<vector<int>> fourSum(vector<int> &arr, int target) {
        // code here
        int n = arr.size();
        vector<vector<int>> res;
        sort(arr.begin(),arr.end());
        for(int i = 0; i<n-3; i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for(int j = i+1; j<n-2; j++){
                if(j>i+1 && arr[j]==arr[j-1]){
                    continue;
                }
                int l = j+1;
                int r = n-1;
                while(l<r){
                    long long sum = (long long)arr[j]+arr[i]+arr[l]+arr[r];
                    if(sum==target){
                        vector<int> temp = {arr[i], arr[j], arr[l], arr[r]};
                        while(l<r && arr[l]==arr[l+1]){l++;}
                        while(l<r && arr[r]==arr[r-1]){r--;}
                        res.push_back(temp);
                        l++;
                        r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
};