package com.ppang.java;

public class Solution {

	public int minLengthUnsortedArray(int[] nums) {
		if (nums==null || nums.length==0) {
			return 0;
		}
		int n = nums.length;
		int start = -1;
		int end = -1;
		for (int i=0; i<n-1; i++) {
			if (nums[i] > nums[i+1]) {
				start = i;
				break;
			}
		}
		if (start==-1) {
			return 0;
		}
		for (int i=n-1; i>=1; i--) {
			if (nums[i] < nums[i-1]) {
				end = i;
				break;
			}
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=start; i<=end; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		for (int i=0; i<start; i++) {
			if (nums[i] > min) {
				start = i;
				break;
			}
		}
		
		for (int i=n-1; i>end; i--) {
			if (nums[i] < max) {
				end = i;
				break;
			}
		}
		
		return end - start + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 2, 3, 8, 7, 6, 5, 9, 10};
		Solution sol = new Solution();
		System.out.println(sol.minLengthUnsortedArray(nums));
	}

}
