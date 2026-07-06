class Solution {
public:
    long long total(vector<int>& piles, int speed){
        long long totalH = 0;
        for (int bananas : piles) {
            totalH += (bananas + speed - 1) / speed;
        }
        return totalH;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();
        int maxi = *max_element(piles.begin(), piles.end());
        int ans = maxi;
        int low = 1;
        int high = maxi;
        while(low<=high){
            int mid = low + (high-low)/2;
            long long totalHours = total(piles,mid);

            if (totalHours <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
};