package com.ppang.LargestValueBinaryTree;

public class Solution {
	public int largestValue(TreeNode root) {
		int[] max = new int[3];
		max[0] = Integer.MIN_VALUE;
		max[1] = Integer.MIN_VALUE;
		max[2] = Integer.MIN_VALUE;
		maxValue(root, max);
		return max[2];
	}
	
	private void maxValue(TreeNode root, int[] max) {
		if (root==null) {
			return;
		}
		if (root.val > max[0]) {
			max[2] = max[1];
			max[1] = max[0];
			max[0] = root.val;
		}
		else if (root.val > max[1]){
			max[2] = max[1];
			max[1] = root.val;
		}
		else if (root.val > max[2]) {
			max[2] = root.val;
		}
		maxValue(root.left, max);
		maxValue(root.right, max);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		Solution sol = new Solution();
		System.out.println(sol.largestValue(root));
	}
}
