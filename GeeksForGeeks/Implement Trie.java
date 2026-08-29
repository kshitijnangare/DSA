class Trie {
    boolean isLeaf;
    Trie[] children;

    public Trie() {
        // Implement Trie
        isLeaf = false;
        children  = new Trie[26];
    }

    // Insert a word into the Trie
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

    // Search for a word in the Trie
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

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
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
        return true;
    }
}