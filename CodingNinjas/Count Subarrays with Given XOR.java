#include <bits/stdc++.h>
using namespace std;
int subarraysXor(vector<int> &arr, int x)
{
    //    Write your code here.
    unordered_map<int, int> m;
    m[0]++;
    int res = 0;
    int prefixor = 0;
    for(int k: arr){
        prefixor = prefixor ^ k;
        if(m.count(prefixor ^ x)==1){
            res = res + m[prefixor ^ x];
        }
        m[prefixor]++;
    }
    return res;
}