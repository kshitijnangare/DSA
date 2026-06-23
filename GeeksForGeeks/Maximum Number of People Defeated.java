class Solution {
    int maxPeopleDefeated(int p) {
        // code here
        int count  =0;
        int line = 1;
        int x = line*line;
        while(x<=p){
            count++;
            line++;
            p = p-x;
            x = line*line;
        }
        return count;
    }
};
