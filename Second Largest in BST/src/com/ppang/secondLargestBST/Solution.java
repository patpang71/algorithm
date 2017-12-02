package com.ppang.secondLargestBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int secondLargestBST(TreeNode root) {
		if (root==null) {
			return -1;
		}
		List<Integer> ans = new ArrayList<Integer>();
		inorder(root, ans);
		int i=0;
		int res = -1;
		for (i=ans.size()-1; i>=ans.size()-2; i--) {
			res = ans.get(i);
		}
		return res;
	}
	
	private void inorder(TreeNode root, List<Integer> ans) {
		if (root==null) {
			return;
		}
		inorder(root.left, ans);
		ans.add(root.val);
		inorder(root.right, ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
