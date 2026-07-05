#include <bits/stdc++.h>
using namespace std;
#include <vector>
#include <unordered_map> 
vector<int> countTheNumber(vector<int> &arr, int n, int k) {
	// Write your code here.
		unordered_map<int, int> mapi;
        unordered_map<int,int> :: iterator it;
        for(int x:arr){
            mapi[x]++;
        }
        vector<int> res;
        for(it = mapi.begin(); it!=mapi.end(); it++){
            if(it->second>=n/k){
                res.push_back(it->first);
            }
        }
        return res;
}