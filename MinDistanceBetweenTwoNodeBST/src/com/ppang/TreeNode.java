package com.ppang;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int v) {
		val = v;
		left = null;
		right = null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TreeNode)) {
			return false;
		}
		TreeNode node = (TreeNode)obj;
		if (node.val == this.val) {
			return true;
		}
		return false;
	}

	public boolean eqauls(TreeNode p) {
		// TODO Auto-generated method stub
		if (this.val == p.val) {
			return true;
		}
		return false;
	}
}
