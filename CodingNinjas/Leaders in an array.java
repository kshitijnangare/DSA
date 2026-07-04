#include <bits/stdc++.h> 
using namespace std;
#include <vector>
vector<int> findLeaders(vector<int> &elements, int n) {
    // Write your code here.
    vector<int> res;
    int maxRight = elements[n-1];
    res.push_back(maxRight);
    for(int i = n-2; i>=0; i--){
        if(elements[i]>maxRight){
            maxRight= elements[i];
            res.push_back(maxRight);
        }
    }
    reverse(res.begin(), res.end());
    return res;
}