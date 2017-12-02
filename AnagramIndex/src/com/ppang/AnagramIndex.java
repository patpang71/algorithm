package com.ppang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramIndex {

	public int[] anagramIndex(String s, String anagram) {
		if (s==null || s.length()==0 || anagram==null || anagram.length()==0) {
			return new int[0];
		}
		Map<Character, Integer> anagramMap = new HashMap<Character, Integer>();
		for (int i=0;i<anagram.length(); i++) {
			anagramMap.put(anagram.charAt(i), anagramMap.getOrDefault(anagram.charAt(i), 0)+1);
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i=0; i<(s.length() - anagram.length())+1; ) {
			char cur = s.charAt(i);
			if (anagramMap.containsKey(cur) && isAnagram(anagram, s.substring(i, i+anagram.length()))) {
				res.add(i);
				i = i + anagram.length();
			}
			else {
				i++;
			}
		}
		if (res.isEmpty()) {
			return new int[0];
		}
		else {
			int[] ans = new int[res.size()];
			int idx = 0;
			for (Integer r : res) {
				ans[idx++] = r;
			}
			return ans;
		}
	}
	
	private boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i<a.length(); i++) {
			map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0)+1);
		}
		for (int i=0; i<b.length(); i++) {
			char cur = b.charAt(i);
			if (!map.containsKey(cur)) {
				return false;
			}
			int freq = map.get(cur);
			freq--;
			if (freq==0) {
				map.remove(cur);
			}
			else {
				map.put(cur, freq);
			}
		}
		return map.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramIndex anagramIdx = new AnagramIndex();
		String s = "ABCDBACDAB";
		String anagram = "ABC";
		int[] res = anagramIdx.anagramIndex(s, anagram);
		for (int r : res) {
			System.out.print(r + ", ");
		}
	}

}
