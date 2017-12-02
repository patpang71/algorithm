package com.ppang;

import java.util.HashMap;
import java.util.Map;

public class ArrayContainsDuplicateWithinK {
	public boolean arrayContainsDuplicateWithinK(int[] nums, int k) {
		if (nums==null || nums.length==0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
			else {
				int lastIdx = map.get(nums[i]);
				if (i - lastIdx < k) {
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
		int[] nums = new int[] {10, 5, 3, 4, 3, 5, 6};
		int k = 3;
		ArrayContainsDuplicateWithinK a = new ArrayContainsDuplicateWithinK();
		System.out.println(a.arrayContainsDuplicateWithinK(nums, k));
	}

}
