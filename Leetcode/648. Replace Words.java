class Trie{
    Trie children[];
    int ind;
    public Trie(){
        children = new Trie[26];
        ind = -1;
    }

    public void insertWord(String word, int ind){
        Trie curr = this;
        int n = word.length();
        for(int i = 0; i<n; i++){
            char c = word.charAt(i);
            int cint = c-'a';

            if(curr.children[cint]==null){
                curr.children[cint] = new Trie();
            }
            curr = curr.children[cint];
        }
        curr.ind = ind;
    }
    
    public int LCS(String word){
        Trie curr = this;
        int n= word.length();
        int i = 0;
        char c = word.charAt(i);
        int cint = c-'a';
        int smallestInd = 0;
        while(curr.children[cint]!=null){
            curr = curr.children[cint];
            if(curr.ind!=-1){
                return curr.ind;
            }
            i++;
            if(i>n-1){
                break;
            }
            c = word.charAt(i);
            cint = c-'a';
        }
        if(i==0){
            return -1;
        }
        return curr.ind;
    }
}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();

        int ldic = dictionary.size();
        for(int i = 0; i<ldic; i++){
            root.insertWord(dictionary.get(i), i);
        }

        String[] sent = sentence.split(" ");
        int lsent = sent.length;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<lsent; i++){
            int res = root.LCS(sent[i]);
            if(res==-1){
                sb.append(sent[i]);
            }else{
                sb.append(dictionary.get(res));
            }
            sb.append(" ");
        }
        String ans = sb.toString();
        return ans.trim();
    }
}