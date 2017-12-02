/**
 * 
 */
package com.ppang;

/**
 * @author ppang
 *
 */
public class TrieNode {
	public TrieNode[] children;
	public boolean hasWord;
	public String word;
	public int rank;
	public TrieNode() {
		children = new TrieNode[26];
		hasWord = false;
		word = "";
		rank = Integer.MAX_VALUE;
	}
	
	public void insert(String word, int rank, int idx) {
		if (idx==word.length()) {
			hasWord = true;
			this.rank = rank;
			this.word = word;
			return;
		}
		int pos = word.charAt(idx) - 'a';
		if (children[pos]==null) {
			children[pos] = new TrieNode();
		}
		children[pos].insert(word, rank, idx+1);
	}
	
	public TrieNode find(String word, int idx) {
		if (idx==word.length()) {
			return this;
		}
		int pos = word.charAt(idx) - 'a';
		if (children[pos]==null) {
			return null;
		}
		return children[pos].find(word, idx+1);
	}
}
