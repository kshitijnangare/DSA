class Trie{
	Trie[] children;
	public Trie(){
		children = new Trie[26];
	}
}
class Solution {
	public static int countSubs(String s) {
		// code here
		int count = 0;
		int n = s.length();
		Trie root = new Trie();
		for (int i = 0 ; i<n; i++) {
			Trie curr = root;
			for (int j = i; j<n; j++) {
				char c = s.charAt(j);
				int cint = c - 'a';
				if (curr.children[cint] == null) {
					curr.children[cint] = new Trie();
					count++;
				}
				curr = curr.children[cint];
			}
		}
		return count;
	}
}
