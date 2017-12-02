package com.ppang.wordMatching;

import java.util.Arrays;
import java.util.List;

public class Solution {

	class TrieNode {
		public TrieNode[] children;
		public boolean hasWord;
		public String word;
		public TrieNode() {
			children = new TrieNode[26];
			hasWord = false;
			word = "";
		}
		
		public void insert(String word, int idx) {
			if (idx==word.length()) {
				hasWord = true;
				this.word = word;
				return;
			}
			int pos = word.charAt(idx) - 'a';
			if (children[pos]==null) {
				children[pos] = new TrieNode();
			}
			children[pos].insert(word, idx+1);
		}
		
		public TrieNode search(String word, int idx) {
			if (idx==word.length()) {
				return this;
			}
			char cur = word.charAt(idx);
			if (cur=='?') {
				for (int i=0; i<26; i++) {
					if (children[i]!=null) {
						TrieNode res = children[i].search(word, idx+1);
						if (res!=null && res.hasWord) {
							return res;
						}
					}
				}
				return null;
			}
			else {
				int pos = cur - 'a';
				if (children[pos]==null) {
					return null;
				}
				return children[pos].search(word, idx+1);
			}
		}
	}
	
	class TrieTree {
		TrieNode root;
		public TrieTree() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			root.insert(word, 0);
		}
		
		public boolean search(String word) {
			TrieNode res = root.search(word, 0);
			if (res!=null && res.hasWord) {
				return true;
			}
			return false;
		}
		
	}
	
	public int matchPatternOnDictory(List<String> dict, String pattern) {
		TrieTree tree = new TrieTree();
		for (String s : dict) {
			tree.insert(s);
		}
		int[] count = new int[1];
		helper(tree.root, pattern, 0, count);
		return count[0];
		
	}
	
	private void helper(TrieNode now, String pattern, int idx, int[] count) {
		if (idx==pattern.length()) {
			count[0]++;
			return;
		}
		char cur = pattern.charAt(idx);
		if (cur=='?') {
			for (int i=0; i<26; i++) {
				if (now.children[i]!=null) {
					helper(now.children[i], pattern, idx+1, count);
				}
			}
		}
		else {
			int pos = cur - 'a';
			if (now.children[pos]==null) {
				return;
			}
			else {
				helper(now.children[pos], pattern, idx+1, count);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = Arrays.asList("cat", "rat", "mat", "apple", "boy", "bat");
		String pattern = "?at";
		Solution sol = new Solution();
		System.out.println(sol.matchPatternOnDictory(dict, pattern));

	}

}
