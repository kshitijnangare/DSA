class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr = new int[52];
        int count = 0;
        for(int i = 0; i<word.length(); i++){
            int n = (int)word.charAt(i);
            System.out.println(n);
            if(n>=65 && n<=90){
                arr[n-65]=1;
            }else{
                arr[n-71]=1;
            }
        }

        for(int i = 0; i<26; i++){
            if(arr[i]==1 && arr[i+26]==1){
                count++;
            }
        }
        return count;

    }
}