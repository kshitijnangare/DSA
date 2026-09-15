class Trie {
	Trie children[];
	public Trie() {
		children = new Trie[2];
	}
	
	public void insert(int num) {
		Trie curr = this;
		for (int i = 31; i >= 0; i--) {
			int bit = ((num>> i) & 1);
			if (curr.children[bit] == null) {
				curr.children[bit] = new Trie();
			}
			curr = curr.children[bit];
		}
	}
	
	public int getMaxXor(int num) {
		Trie curr = this;
		int maxNum = 0;
		for (int i = 31; i >= 0; i--) {
			int bit = ((num>> i) & 1);
			int flipbit = bit ^ 1;
			if (curr.children[flipbit] != null) {
				curr = curr.children[flipbit];
				maxNum = maxNum | (1 << i);
			} else {
				curr = curr.children[bit];
			}
		}
		return maxNum;
	}
}

class Solution {
	public int maxXor(int[] arr) {
		// code here
		Trie root = new Trie();
		
		for (int x: arr) {
			root.insert(x);
		}
		
		int max = 0;
		for (int x: arr) {
			int currmax = root.getMaxXor(x);
			max = Math.max(max, currmax);
		}
		return max;
		
	}
}
