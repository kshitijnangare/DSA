class Solution {
  public:
    int kokoEat(vector<int>& arr, int k) {
        // Code here
        int n = arr.size();
        int maxi = *max_element(arr.begin(), arr.end());
        int ans = maxi;
        int low = 1;
        int high = maxi;
        while(low<=high){
            int mid = low + (high-low)/2;
            long long totalHours = total(arr,mid);

            if (totalHours <= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
        
    }
    long long total(vector<int>& arr, int speed){
        long long totalH = 0;
        for (int bananas : arr) {
            totalH += (bananas + speed - 1) / speed;
        }
        return totalH;
    }
};