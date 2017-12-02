package com.ppang;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicateWithinK {

	public boolean checkDupWithinK(int[] nums, int k) {
		if (nums==null || nums.length==0 || k > nums.length) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++) {
			if (map.isEmpty() || !map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
			else {
				int prev = map.get(nums[i]);
				if (i - prev <= k) {
					return true;
				}
				else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 2, 1, 4, 1, 2, 3, 4};
		int k = 3;
		CheckDuplicateWithinK check = new CheckDuplicateWithinK();
		boolean res = check.checkDupWithinK(nums, k);
		System.out.println(res);
	}

}
