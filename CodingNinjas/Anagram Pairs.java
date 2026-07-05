using namespace std;
#include <unordered_map>
bool isAnagram(string str1, string str2)
{
    //Write your code here
    unordered_map<char,int> maps;
        unordered_map<char,int> mapt;
        for(char c:str1){
            maps[c]++;
        }
        for(char c:str2){
            mapt[c]++;
        }
        if(maps==mapt){
            return true;
        }else{
            return false;
        }
}