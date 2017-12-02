package com.ppang;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int longestIncreasingSubSeq(int[] nums) {
		if (nums==null || nums.length==0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					if (dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0, 1, 3, 2, 2, 3, 4};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.longestIncreasingSubSeq(nums));
	}

}
