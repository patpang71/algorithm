package com.ppang;

public class NextPermutation {
	
	public void nextPermutation(int[] nums) {
		if (nums==null || nums.length<=1) {
			return;
		}
		int i=nums.length-2;
		while (i>=0 && nums[i] > nums[i+1]) {
			i--;
		}
		if (i>=0) {
			int j = nums.length-1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i+1, nums.length-1);
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private void reverse(int[] nums, int i, int j) {
		while (i<j) {
			swap(nums, i++, j--);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 3, 2, 4};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(nums);
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
	}

}
