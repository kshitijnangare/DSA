class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        transpose(matrix);
        int n = matrix.size();
        for(int i = 0; i<n; i++){
            int l = 0; int r = n-1;
            while(l<r){
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r]=t;
                l++;
                r--;
            }
        }
    }
    void transpose(vector<vector<int>>& matrix){
        int n = matrix.size();
        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }
};