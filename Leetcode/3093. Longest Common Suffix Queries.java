class Trie{
    Trie children[];
    int ind;
    int bestInd;
    public Trie(){
        children = new Trie[26];
        bestInd = -1;
    }

    public void insertWord(String word, int ind, String[] wordsContainer){
        Trie curr = this;

        if (curr.bestInd == -1 || word.length() < wordsContainer[curr.bestInd].length()) {
            curr.bestInd = ind;
        }

        int n = word.length();
        for(int i = n-1; i>=0; i--){
            char c = word.charAt(i);
            int cint = c-'a';

            if(curr.children[cint]==null){
                curr.children[cint] = new Trie();
            }
            curr = curr.children[cint];

            if (curr.bestInd == -1 || word.length() < wordsContainer[curr.bestInd].length()) {
                curr.bestInd = ind;
            }
        }
        if(curr.ind==-1){
            curr.ind = ind;
        }
    }
    
    // public int LCS(String word){
    //     Trie curr = this;
    //     int n= word.length();
    //     int i = n-1;
    //     char c = word.charAt(i);
    //     int cint = c-'a';
    //     while(curr.children[cint]!=null){
    //         curr = curr.children[cint];
    //         i--;
    //         if(i<0){
    //             break;
    //         }
    //         c = word.charAt(i);
    //         cint = c-'a';
    //     }
    //     if(i==n-1){
    //         return -1;
    //     }
    //     if(curr.ind !=-1){
    //         return curr.ind;
    //     }
    //     int ans = BFS(curr);
    //     return ans;
    // }

    // public int BFS(Trie root){
    //     Queue<Trie> q = new LinkedList<>();
    //     q.add(root);
    //     int MAX = 1000000000;
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         int minInd = MAX;
    //         for(int i = 0; i<size; i++){
    //             Trie curr = q.poll();
    //             if(curr.ind!=-1){
    //                 minInd = Math.min(curr.ind, minInd);
    //             }
    //             for(int k = 0; k<26; k++){
    //                 if(curr.children[k]!=null){
    //                     q.add(curr.children[k]);
    //                 }
    //             }
    //         }
    //         if(minInd!=MAX){
    //             return minInd;
    //         }
    //     }
    //     return -1;
    // }

    public int LCS(String word) {
        Trie curr = this;
        int n = word.length();
        for(int i = n - 1; i >= 0; i--) {
            char c = word.charAt(i);
            int cint = c - 'a';
            
            if (curr.children[cint] == null) {
                break;
            }
            curr = curr.children[cint];
        }
        
        return curr.bestInd;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie root = new Trie();
        int min = wordsContainer[0].length();
        int sli = 0;
        for(int i = 0; i<wordsContainer.length; i++){
            String word = wordsContainer[i];
            root.insertWord(word, i, wordsContainer);
            if(word.length()<min){
                sli=i;
                min = word.length();
            }
        }

        int n = wordsQuery.length;
        int[] res = new int[n];

        for(int i = 0; i<n; i++){
            String word = wordsQuery[i];
            int resi = root.LCS(word);
            if(resi==-1){
                res[i] = sli;
            }else{
                res[i] = resi;
            }
        }
        return res;
    }
}