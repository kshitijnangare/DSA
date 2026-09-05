import java.util.* ;
import java.io.*; 


class Trie{
  boolean isLeaf;
  Trie[] children;
  public Trie(){
    isLeaf=false;
    children = new Trie[26];
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
      }else{
        curr = curr.children[cint];
      }
    }
    curr.isLeaf=true;
  }

  public boolean prefixPresent(String word){
    int len = word.length();
    Trie curr = this;

    for(int i = 0; i<len; i++){
      char c = word.charAt(i);
      int cint = c-'a';
      curr = curr.children[cint];
      if(curr.isLeaf==false){
        return false;
      }
    }
    return true;
  }
}

class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
    Trie root = new Trie();
    Arrays.sort(a);
    for(int i = 0; i<n; i++){
      root.insert(a[i]);
    }
    String s = "None";
    int len = 0;
    for(int i = 0; i<n; i++){
      if(root.prefixPresent(a[i])==true){
        if(len<a[i].length()){
          s = a[i];
          len = a[i].length();
        }
      }
    }
    return s;

  }
}