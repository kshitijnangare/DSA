import java.util.* ;
import java.io.*; 
public class Trie {
    int ew;
    int cp;
    Trie[] children;
    public Trie() {
        // Write your code here.
        ew = 0;
        cp = 0;
        children = new Trie[26];
    }

    public void insert(String word) {
        // Write your code here.
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
                curr=curr.children[cint];
                curr.cp++;
            }
        }
        curr.ew++;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
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
        return curr.ew;

    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
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

    public void erase(String word) {
        // Write your code here.
        int len = word.length();
        Trie curr = this;

        for(int i = 0; i<len; i++){
            char c = word.charAt(i);
            int cint = c-'a';

            curr = curr.children[cint];
            curr.cp--;
        }
        curr.ew--;
    }

}
