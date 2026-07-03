vector<vector<int>> triplet(int n, vector<int> &arr)
{
    // Write your code here.
    vector<vector<int>> res;
        sort(arr.begin(), arr.end());
        for(int i = 0; i<n-2; i++){
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int currTarget = 0-arr[i];
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = arr[l]+arr[r];
                if(sum ==currTarget){
                    vector<int> temp = {arr[i], arr[l], arr[r]};
                    while(l<r && arr[l]==arr[l+1]){l++;}
                    while(l<r && arr[r]==arr[r-1]){r--;}
                    res.push_back(temp);
                    l++;
                    r--;
                }else if(sum<currTarget){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
}
