/**
 * 
 */
package com.ppang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ppang
 *
 */
public class JumbledNumber {
	
	public List<Integer> jumbledNumber(int n) {
		List<Integer> ans = new ArrayList<Integer>();
		if (n <= 1) {
			return ans;
		}
		int[] digits = new int[n];
		Arrays.fill(digits, 0);
		digits[0] = 1;
		ans.add(convertToNumber(digits));
		while (convertToNumber(digits) < Math.pow(10, n)) {
			for (int j=digits.length-1; j>=0)
		}
	}
	
	private int convertToNumber(int[] digits) {
		int res = 0;
		for (int i=0; i<digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
