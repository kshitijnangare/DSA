public class Trie {


    //Initialize your data structure here
    boolean isLeaf;
    Trie[] children;
    static Trie root = new Trie();
    Trie() {
        //Write your code here
        isLeaf = false;
        children  = new Trie[26];
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        //Write your code here
        int len = word.length();
        Trie curr = root;
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
        curr.isLeaf=true;
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        //Write your code here
        int len = word.length();
        Trie curr = root;
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

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        //Write your code here
        int len = prefix.length();
        Trie curr = root;
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