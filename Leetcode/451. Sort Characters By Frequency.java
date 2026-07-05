class Solution {
// private: // this is alos one of the options to declare comparator in c++
//     static bool comparator(pair<int, char> p1, pair<int, char> p2) {
//         if (p1.first > p2.first) return true;
//         if (p1.first < p2.first) return false;
//         return p1.second < p2.second;
//     }
public:
    string frequencySort(string s) {
        vector<pair<int, char>> freq(256);
        for (int i = 0; i < 256; i++) {
            freq[i] = {0, (char)i};
        }
        for (char ch : s) {
            freq[(unsigned char)ch].first++;
        }
        sort(freq.begin(), freq.end(), [](const pair<int, char>& p1, const pair<int, char>& p2) {
            if (p1.first != p2.first) {
                return p1.first > p2.first;
            }
            return p1.second < p2.second; 
        });

        string result = "";
        for (const auto& p : freq) {
            if (p.first > 0) {
                result.append(string(p.first, p.second));
            }
        }
        
        return result;
    }
};