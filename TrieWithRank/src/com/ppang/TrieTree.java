/**
 * 
 */
package com.ppang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ppang
 *
 */
public class TrieTree {
	TrieNode root;
	public TrieTree() {
		root = new TrieNode();
	}
	
	public void insert(String word, int rank) {
		root.insert(word, rank, 0);
	}
	
	public List<TrieNode> findWithPrefix(String prefix) {
		List<TrieNode> ans = new ArrayList<TrieNode>();
		TrieNode res = root.find(prefix, 0);
		if (res==null) {
			return ans;
		}
		if (res.hasWord) {
			ans.add(res);
		}
		for (int i=0; i<26; i++) {
			if (res.children[i]!=null) {
				helper(ans, res.children[i]);
			}
		}
		return ans;
	}
	
	private void helper(List<TrieNode> ans, TrieNode cur) {
		if (cur!=null && cur.hasWord) {
			ans.add(cur);
		}
		for (int i=0; i<26; i++) {
			if (cur.children[i]!=null) {
				helper(ans, cur.children[i]);
			}
		}
	}
}
