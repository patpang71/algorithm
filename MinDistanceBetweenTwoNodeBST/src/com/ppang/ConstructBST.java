package com.ppang;

public class ConstructBST {
	public TreeNode constructBST(int[] nums) {
		if (nums==null || nums.length==0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[0]);
		for (int i=1; i<nums.length; i++) {
			addNode(root, nums[i]);
		}
		return root;
	}
	
	private void addNode(TreeNode root, int val) {
		if (root==null) {
			root = new TreeNode(val);
			return;
		}
		if (root.val > val && root.left==null) {
			root.left = new TreeNode(val);
		}
		else if (root.val > val) {
			addNode(root.left, val);
		}
		else if (root.val < val && root.right==null) {
			root.right = new TreeNode(val);
		}
		else if (root.val < val) {
			addNode(root.right, val);
		}
	}
}
