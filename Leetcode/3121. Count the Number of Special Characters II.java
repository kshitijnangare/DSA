class Solution {
    public int numberOfSpecialChars(String word) {
        int[] visited = new int[26];
        int[] banned = new int[26];
        HashSet<Character> set = new HashSet<>();
        // Arrays.fill(visited, 0);
        int count = 0;

        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            int n = (int)c;
            if(n>=97 && c<=122){
                if(banned[n-97]==1){
                    visited[n-97]=0;
                    set.remove(c);
                }else{
                    set.add(c);
                } 
            }else{
                banned[n-65]=1;
                if(set.contains((char)(n+32))){
                    visited[n-65]=1;
                }
            }
        }
        for(int x: visited){
            if(x==1){
                count++;
            }
        }
        return count;
    }
}