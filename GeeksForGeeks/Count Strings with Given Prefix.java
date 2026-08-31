class Trie{
    Trie[] children;
    int ew;
    int cp;
    
    public Trie(){
        children = new Trie[26];
        ew = 0;
        cp = 0;
    }
    
    public void insert(String word){
        int len = word.length();
        Trie curr = this;
        for(int i = 0; i<len; i++){
            char c = word.charAt(i);
            int cint = c-'a';
            
            if(curr.children[cint]==null){
                Trie temp = new Trie();
                curr.children[cint]=temp;
                curr = temp;
                curr.cp++;
            }else{
                curr = curr.children[cint];
                curr.cp++;
            }
        }
        curr.ew++;
    }
    
    public int countPrefix(String word){
        int len = word.length();
        Trie curr = this;
        
        for(int i = 0; i<len; i++){
            char c = word.charAt(i);
            int cint = c-'a';
            
            if(curr.children[cint]==null){
                return 0;
            }
            curr = curr.children[cint];
        }
        return curr.cp;
    }
}

class Solution {
    ArrayList<Integer> prefCount(ArrayList<String> s, ArrayList<String> q) {
        // code here
        Trie root = new Trie();
        for(String st: s){
            root.insert(st);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(String st: q){
            int c = root.countPrefix(st);
            res.add(c);
        }
        return res;
    }
}