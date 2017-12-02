package com.ppang;

import java.util.Arrays;

public class NumberOfLongestSequence {
	
	public int numberOfLongestSequence(int[] nums) {
		if (nums==null || nums.length==0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int[] ans = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.fill(ans, 1);
		int max = 1;
		for (int i=1; i<nums.length; i++) {
			for (int j=0; j<i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[j]+1 > dp[i]) {
						dp[i] = dp[j] + 1;
						ans[i] = ans[j];
					}
					else if (dp[j]+1==dp[i]) {
						ans[i] = ans[i] + ans[j];
					}
				}
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		int count = 0;
		for (int i=0; i<nums.length; i++) {
			if (dp[i]==max) {
				count = count + ans[i];
			}
		}
		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 3, 5, 4, 7};
		NumberOfLongestSequence n = new NumberOfLongestSequence();
		int res = n.numberOfLongestSequence(nums);
		System.out.println(res);
	}

}
