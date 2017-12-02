package com.ppang;

public class SquareRoot {

	public int sqrt(int x) {
		if (x <= 1) {
			return x;
		}
		long left = 1;
		long right = x;
		while (left+1 < right) {
			long mid = (left + right)/2;
			long prod = mid * mid;
			if (prod==x) {
				return (int)mid;
			}
			else if (prod < x) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		if (right * right <= x) {
			return (int)right;
		}
		return (int)left;
	}
	
	public double sqrtDecimal(int x, int k) {
		if (x <= 1) {
			return x;
		}
		long left = 1;
		long right = x;
		double result = 0;
		while (left+1 < right) {
			long mid = (left + right)/2;
			long prod = mid * mid;
			if (prod==x) {
				return (double)mid;
			}
			else if (prod < x) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		if (right * right== x) {
			return right;
		}
		else if (right * right < x) {
			result = right;
		}
		else if (left * left == x) {
			return left;
		}
		else if (left * left < x) {
			result = left;
		}
		
		for (int i=0; i<k; i++) {
			int start = 0;
			int end = 9;
			while (start+1 < end) {
				int mid = (start + end)/2;
				double midRes = result + (double)(mid)/(double)(Math.pow(10, i+1));
				double prodRes = midRes * midRes;
				if (prodRes == x) {
					return midRes;
				}
				else if (prodRes < x) {
					start = mid;
				}
				else {
					end = mid;
				}
			}
			double endRes = result + (double)end/(double)(Math.pow(10, i+1));
			double startRes = result + (double)start/(double)(Math.pow(10, i+1));
			if (endRes * endRes == x) {
				return endRes;
			}
			else if (endRes * endRes < x) {
				result = endRes;
			}
			else if (startRes * startRes == x) {
				return startRes;
			}
			else if (startRes * startRes < x) {
				result = startRes;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareRoot sq = new SquareRoot();
		System.out.println(sq.sqrtDecimal(8, 5));
	}

}
