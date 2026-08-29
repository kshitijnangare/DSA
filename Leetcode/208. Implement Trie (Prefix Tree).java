class Trie {
    boolean isLeaf;
    Trie[] children;
    
    public Trie() {
        isLeaf = false;
        children  = new Trie[26];
    }
    
    public void insert(String word) {
        int len = word.length();
        Trie curr = this;
        for(int i =0; i<len; i++){
            char c = word.charAt(i);
            int cint = c-'a';
            if(curr.children[cint]==null){
                Trie temp = new Trie();
                curr.children[cint]=temp;
                curr = temp;
            }else{
                curr = curr.children[cint];
            }
        }
        curr.isLeaf = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        Trie curr = this;
        for(int i =0; i<len; i++){
            char c = word.charAt(i);
            int cint = c-'a';
            if(curr.children[cint]==null){
                return false;
            }
            curr = curr.children[cint];
        }
        if(curr.isLeaf==false){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Trie curr = this;
        for(int i =0; i<len; i++){
            char c = prefix.charAt(i);
            int cint = c-'a';
            if(curr.children[cint]==null){
                return false;
            }
            curr = curr.children[cint];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */