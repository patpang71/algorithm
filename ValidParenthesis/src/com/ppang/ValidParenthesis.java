package com.ppang;

import java.util.Stack;

public class ValidParenthesis {
	
	public boolean extendedValidParenthesis(String s) {
		if (s==null || s.length()==0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		int noOfWildCard = 0;
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if (cur=='(' || cur=='[' || cur=='{') {
				stack.push(cur);
			}
			else if (cur==')' || cur==']' || cur=='}') {
				if (cur==')') {
					if (stack.peek()=='(') {
						stack.pop();
					}
					else if (noOfWildCard > 0) {
						noOfWildCard--;
					}
					else {
						return false;
					}
				}
				else if (cur==']') {
					if (stack.peek()=='[') {
						stack.pop();
					}
					else if (noOfWildCard > 0) {
						noOfWildCard--;
					}
					else {
						return false;
					}
				}
				else {
					if (stack.peek()=='{') {
						stack.pop();
					}
					else if (noOfWildCard > 0) {
						noOfWildCard--;
					}
					else {
						return false;
					}
				}
			}
			else if (cur=='*') {
				noOfWildCard++;
			}
		}
		while (!stack.isEmpty() && noOfWildCard > 0) {
			stack.pop();
			noOfWildCard--;
		}
		return stack.isEmpty();
	}
	
	public boolean validParenthesis(String s) {
		if (s==null || s.length()==0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		int noOfWildCard = 0;
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if (cur=='(') {
				stack.push(cur);
			}
			else if (cur==')') {
				if (stack.isEmpty()) {
					noOfWildCard--;
					if (noOfWildCard<0) {
						return false;
					}
				}
				else {
					stack.pop();
				}
			}
			else if (cur=='*') {
				noOfWildCard++;
			}
		}
		while (!stack.isEmpty()) {
			if (noOfWildCard > 0) {
				stack.pop();
				noOfWildCard--;
			}
			if (noOfWildCard==0 || stack.isEmpty()) {
				break;
			}
		}
		return stack.isEmpty();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParenthesis valid = new ValidParenthesis();
		System.out.println(valid.validParenthesis("((((***(**"));
		
		System.out.println(valid.extendedValidParenthesis("{[((**(]}"));
	}

}
