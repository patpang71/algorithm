package com.ppang;

public class Main {

	public TreeNode findLCAofBST(TreeNode root, TreeNode p, TreeNode q) {
		if (root==null) {
			return null;
		}
		if (root.val < p.val && root.val < q.val) {
			return findLCAofBST(root.left, p, q);
		}
		if (root.val > p.val && root.val > q.val) {
			return findLCAofBST(root.right, p, q);
		}
		if (root.val==p.val || root.val==q.val) {
			return root;
		}
		if (root.val > p.val && root.val < q.val) {
			return root;
		}
		if (root.val < p.val && root.val > q.val) {
			return root;
		}
		return null;
	}
	
	public int findDistance(TreeNode root, TreeNode p, int dist) {
		if (root==null) {
			return -1;
		}
		if (root.eqauls(p)) {
			return dist;
		}
		if (root.val < p.val) {
			return findDistance(root.right, p, dist+1);
		}
		if (root.val > p.val) {
			return findDistance(root.left, p, dist+1);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {5, 6, 3, 1, 2, 4};
		ConstructBST bst = new ConstructBST();
		TreeNode root = bst.constructBST(nums);
		int left = 1;
		int right = 6;
		TreeNode leftNode = new TreeNode(left);
		TreeNode rightNode = new TreeNode(right);
		Main main = new Main();
		TreeNode lcaNode = main.findLCAofBST(root, leftNode, rightNode);
		int leftDist = main.findDistance(lcaNode, leftNode, 0);
		int rightDist = main.findDistance(lcaNode, rightNode, 0);
		if (leftDist==-1 || rightDist==-1) {
			System.out.println("Cannot find one of the node");
		}
		else {
			System.out.println("Total Distance: " + (leftDist + rightDist));
		}
	}
}
