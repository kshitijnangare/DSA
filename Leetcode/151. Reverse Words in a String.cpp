class Solution {
public:
    string reverseWords(string s) {
       cout<<"|" + s + "|" + "\n";
        int shifting = 0;
        int consSpace = 0;
        int n = s.size();
        int i = 0;
        while(i<n && s[i]==' '){
            shifting++;
            i++;
        }
        for(; i<n; i++){
            char c = s[i];
            if(c==' '){
                consSpace++;
            }else{
                consSpace = 0;
            }
            if(consSpace>1){
                shifting++;
                continue;
            }
            s[i-shifting] = s[i];
        }
        
        int cleanLen = n - shifting;
        if (cleanLen > 0 && s[cleanLen - 1] == ' ') {
            cleanLen--;
        }
        cout<<"|" + s + "|" + "\n";
        s.resize(cleanLen);

        cout<<"|" + s + "|";

        reverse(s.begin(), s.end());
        n = s.size();
        int l = 0;
        for(int i = 0; i<n; i++){
            char c = s[i];
            if(c==' '){
                reverse(s.begin()+l, s.begin()+i);
                l = i+1;
            }
        }
        reverse(s.begin() + l, s.begin() + n);
        return s;
    }
};