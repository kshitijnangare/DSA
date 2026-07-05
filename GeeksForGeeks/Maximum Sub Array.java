class Solution {
  public:
    vector<int> findSubarray(vector<int>& arr) {
        // code here
        int maxLen = 0;
        int s = 0;
        int e = 0;
        int maxSum = 0;
        int sum = 0;
        int len = 0;
        int maxs = 0;
        int maxe=0;
        
        for(int x: arr){
            if(x<0){
                if(sum>maxSum){
                    maxe = e;
                    maxs = s;
                    maxSum = sum;
                }else if(sum==maxSum){
                    if( (maxe-maxs) < (e-s) ){
                        maxe=e;
                        maxs=s;
                        
                    }  
                }
                s = e+1;
                e = e+1;
                sum = 0;
            }else{
                e++;
                sum = sum + x;
            }
        }
        if(sum>maxSum){
            maxe = e;
            maxs = s;
            maxSum = sum;
            sum = 0;
        }else if(sum==maxSum){
            if( (maxe-maxs) < (e-s) ){
                maxe=e;
                maxs=s;
                sum = 0;
            }  
        }
        vector<int> res;
        if(maxSum==0){
            res.push_back(-1);
            return res;
        }
        for(int i = maxs; i<maxe; i++){
            res.push_back(arr[i]);
        }
        return res;
    }
};