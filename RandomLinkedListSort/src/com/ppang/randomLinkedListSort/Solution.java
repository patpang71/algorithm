package com.ppang.randomLinkedListSort;

import java.util.*;

public class Solution {

	class Comp implements Comparator<RandomListNode> {
		public int compare(RandomListNode a, RandomListNode b) {
			return a.val - b.val;
		}
	}
	
	public RandomListNode sortRandom(RandomListNode root) {
		if (root==null || root.next==null) {
			return root;
		}
		List<RandomListNode> list = new ArrayList<RandomListNode>();
		RandomListNode cur = root;
		while (cur!=null) {
			list.add(cur);
			cur = cur.next;
		}
		Collections.sort(list, new Comp());
		RandomListNode prev = list.get(0);
		RandomListNode head = list.get(0);
		for (int i=1; i<list.size(); i++) {
			cur = list.get(i);
			prev.random = cur;
			prev = cur;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
