class Trie {
	boolean isLeaf;
	Trie[] children;
	public Trie() {
		isLeaf = false;
		children = new Trie[26];
	}
	
	public void insert(String word) {
		int len = word.length();
		Trie curr = this;
		
		for (int i = 0; i<len; i++) {
			char c = word.charAt(i);
			int cint = c - 'a';
			if (curr.children[cint] == null) {
				Trie temp = new Trie();
				curr.children[cint] = temp;
				curr = temp;
			} else {
				curr = curr.children[cint];
			}
		}
		curr.isLeaf = true;
	}
	
	public boolean prefixPresent(String word) {
		int len = word.length();
		Trie curr = this;
		
		for (int i = 0; i<len; i++) {
			char c = word.charAt(i);
			int cint = c - 'a';
			curr = curr.children[cint];
			if (curr.isLeaf == false) {
				return false;
			}
		}
		return true;
	}
}

class Solution {
	public String longestValidWord(String[] words) {
		// code here
		Trie root = new Trie();
		Arrays.sort(words);
		int n = words.length;
		for (int i = 0; i<n; i++) {
			root.insert(words[i]);
		}
		String s = "";
		int len = 0;
		for (int i = 0; i<n; i++) {
			if (root.prefixPresent(words[i]) == true) {
				if (len<words[i].length()) {
					s = words[i];
					len = words[i].length();
				}
			}
		}
		return s;
	}
}
