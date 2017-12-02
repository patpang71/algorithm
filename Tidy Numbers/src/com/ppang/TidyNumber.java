package com.ppang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TidyNumber {
	BufferedReader br;
	PrintWriter pw;
	int noOfLine;
	
	private String minusOne(String num) {
		StringBuilder rev = new StringBuilder();
		int carry = -1;
		int i=num.length()-1;
		while (i>=0) {
			char cur = num.charAt(i);
			if (carry==-1 && cur=='0') {
				cur = '9';
				carry = -1;
			}
			else if (carry==-1){
				//cur = cur--;
				int val = cur - '0';
				val--;
				cur = Character.forDigit(val, 10);
				carry = 0;
			}
			rev.append(cur);
			i--;
		}
		while (rev.length()>0 && rev.charAt(rev.length()-1)=='0') {
			rev.deleteCharAt(rev.length()-1);
		}
		StringBuilder sb = rev.reverse();
		if (sb.toString().equals("0")) {
			return "";
		}
		return sb.toString();
	}
	
	private String setToNine(String num) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<num.length(); i++) {
			sb.append('9');
		}
		return sb.toString();
	}
	
	private boolean isTidy(String num) {
		if (num.length()==1) {
			return true;
		}
		char prev = '0';
		for (int i=0; i<num.length(); i++) {
			char cur = num.charAt(i);
			if (prev > cur) {
				return false;
			}
			prev = cur;
		}
		return true;
	}
	
	private String largestTidy(String num) {
		if (num.length()==1) {
			return num;
		}
		char prev = '0';
		int idx = 0;
		
		for (int i=0; i<num.length(); i++) {
			char cur = num.charAt(i);
			if (cur >= prev) {
				prev = cur;
			}
			else if (cur < prev) {
				idx = i;
				break;
			}
		}
		if (idx==0) {
			return num;
		}
		String left = num.substring(0, idx);
		String right = num.substring(idx);
		left = minusOne(left);
		right = setToNine(right);
		if (isTidy(left + right)) {
			return left + right;
		}
		return largestTidy(left + right);
		/*
		while (num.length()>1) {
			if(isTidy(num)) {
				return num;
			}
			num = minusOne(num);
		}
		return num;
		*/
	}
	
	public void run(String inputFile, String outputFile) {
		try {
			br = new BufferedReader(new FileReader(inputFile));
			pw = new PrintWriter(outputFile);
			String noStr = br.readLine();
			noOfLine = Integer.parseInt(noStr);
			for (int i=0; i<noOfLine; i++) {
				String input = br.readLine();
				String res = largestTidy(input);
				pw.println("Case #" + (i+1) + ": " + res);
			}
			
		}
		catch(NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			nfe.printStackTrace();
		}
		catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			fnf.printStackTrace();
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (br!=null) {
					br.close();
				}
				if (pw!=null) {
					pw.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TidyNumber tn = new TidyNumber();
		String inputFile = "B.in";
		String outputFile = "B.out";
		tn.run(inputFile, outputFile);
	}

}
