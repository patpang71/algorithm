/**
 * 
 */
package com.ppang;

/**
 * @author ppang
 *
 */
public class StringAddSub {
	
	public int addSub(String strInput) {
		
	}

	public int stringAddSub(String strinput) {
		if (strinput.length()==0) {
			return 0;
		}
		String operation = strinput.substring(0, 3);
		int res = 0;
		if (operation.equals("add")) {
			String digInputstr = strinput.substring(4, strinput.length()-1);
			String[] digInput = digInputstr.split(",");
			for (String dig : digInput) {
				if (isInteger(dig.trim())) {
					res = res + Integer.parseInt(dig.trim());
				}
				else {
					res = res + stringAddSub(dig.trim());
				}
			}
		}
		else {
			String digInputStr = strinput.substring(4, strinput.length()-1);
			String[] digInput = digInputStr.split(",");
			String leftStr = digInput[0].trim();
			int left = 0;
			String rightStr = digInput[1].trim();
			int right = 0;
			if (isInteger(leftStr)) {
				left = Integer.parseInt(leftStr);
			}
			else {
				left = stringAddSub(leftStr);
			}
			if (isInteger(rightStr)) {
				res = res + Integer.parseInt(rightStr);
			}
			else {
				right = stringAddSub(rightStr);
			}
			res = left - right;
		}
		return res;
	}
	
	private boolean isInteger(String strIn) {
		try {
			Integer.parseInt(strIn);
		}
		catch(NumberFormatException e) {
			return false;
		}
		catch(NullPointerException ne) {
			return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAddSub s = new StringAddSub();
		int res = s.stringAddSub("add(add(1,2),sub(3,4))");
		System.out.print(res);
	}

}
