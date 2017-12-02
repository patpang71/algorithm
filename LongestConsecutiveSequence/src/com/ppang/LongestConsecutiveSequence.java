/**
 * 
 */
package com.ppang;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.JUnitCore;

/**
 * @author ppang
 *
 */
public class LongestConsecutiveSequence {
	
	public static int longestConsecutiveSequence(int[] nums) {
		if (nums==null || nums.length==0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++) {
			map.put(nums[i], 1);
		}
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(nums[i]-1)) {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JUnitCore.main("com.ppang.LongestConsecutiveSequence");
	}

}
