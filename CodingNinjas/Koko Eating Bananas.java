using namespace std;
#include <vector>
long long total(vector<int>& v, int speed){
    long long totalH = 0;
    for (int bananas : v) {
        totalH += (bananas + speed - 1) / speed;
    }
    return totalH;
}


int minimumRateToEatBananas(vector<int> v, int h) {
    // Write Your Code Here
    int n = v.size();
        int maxi = *max_element(v.begin(), v.end());
        int ans = maxi;
        int low = 1;
        int high = maxi;
        while(low<=high){
            int mid = low + (high-low)/2;
            long long totalHours = total(v,mid);

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