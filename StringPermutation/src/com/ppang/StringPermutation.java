package com.ppang;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public List<String> stringPermutation(String s) {
		List<String> ans = new ArrayList<String>();
		if (s==null || s.length()==0) {
			return ans;
		}
		List<Character> cur = new ArrayList<Character>();
		boolean[] visited = new boolean[s.length()];
		helper(ans, cur, visited, s);
		return ans;
	}
	
	private void helper(List<String> ans, List<Character> cur, boolean[] visited, String s) {
		if (cur.size()==s.length()) {
			StringBuilder sb = new StringBuilder();
			for (Character c : cur) {
				sb.append(c);
			}
			ans.add(sb.toString());
			return;
		}
		for (int i=0; i<s.length(); i++) {
			if (visited[i]) {
				continue;
			}
			char c = s.charAt(i);
			visited[i] = true;
			cur.add(c);
			helper(ans, cur, visited, s);
			cur.remove(cur.size()-1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		StringPermutation sp = new StringPermutation();
		List<String> ans = sp.stringPermutation(s);
		for (String res : ans) {
			System.out.println(res);
		}
	}

}
