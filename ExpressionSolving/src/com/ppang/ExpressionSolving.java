package com.ppang;

public class ExpressionSolving {

	public double expressionSolving(String s, int xValue) {
		int noOfX = 0;
		int noOfY = 0;
		int value = 0;
		boolean beforeEqual = true;
		int sign = 1;
		int val = 0;
		s = s.replace(" ", "");
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if (Character.isDigit(cur)) {
				val = (int)(cur - '0');
				int j=i+1;
				while (j<s.length() && Character.isDigit(s.charAt(j))) {
					val = val * 10 + (int)(s.charAt(j) - '0');
					j++;
				}
			}
			else if (cur=='x' || cur=='y') {
				if (cur=='x') {
					if (beforeEqual) {
						noOfX = noOfX + sign * val;
					}
					else {
						noOfX = noOfX + sign * -1 * val;
					}
				}
				else {
					if (beforeEqual) {
						noOfY = noOfY + sign * val;
					}
					else {
						noOfY = noOfY + sign * -1 * val;
					}
				}
				val = 0;
				sign = 1;
			}
			else if (cur=='+') {
				if (val!=0) {
					value = value + sign * val;
				}
				val = 0;
				sign = 1;
			}
			else if (cur=='-') {
				if (val!=0) {
					value = value + sign * val;
				}
				val = 0;
				sign = -1;
			}
			else if (cur=='=') {
				if (val!=0) {
					value = value + sign * val;
				}
				val = 0;
				sign = 1;
				beforeEqual = false;
			}
		}
		if (val!=0) {
			value = value + sign * val;
		}
		return -(double)(value + noOfX * xValue) /(double) noOfY;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionSolving es = new ExpressionSolving();
		double res = es.expressionSolving("2x+3y+4 = 5x-6y+1", 5);
		System.out.println("Result: " + res);
	}

}
