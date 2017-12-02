/**
 * 
 */
package com.ppang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class OversizedPancakeFlipper {
	BufferedReader br;
	PrintWriter out;
	
	public static void main (String[] args) {
		OversizedPancakeFlipper a = new OversizedPancakeFlipper();
		a.run();
	}
	
	private void run() {
		try {
			//br = new BufferedReader(new FileReader(this.getClass().getSimpleName().substring(0, 1) + ".in"));
			br = new BufferedReader(new FileReader("A.in"));
			//out = new PrintWriter(this.getClass().getSimpleName().substring(0, 1) + ".out");
			out = new PrintWriter("A.out");
			int count = 0;
			String line = "";
			line = br.readLine();
			int n = Integer.parseInt(line);
			while (count < n && (line=br.readLine())!=null) {
				String[] split = line.split(" ");
				String res = solve(split);
				out.println("Case #" + (count+1) + ": " + res);
				count++;
			}
			
		} 
		catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if (out!=null) {
					out.close();
				}
				if (br!=null) {
					br.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String solve(String[] input) throws IOException {
		
		if (input[0]==null || input[0].length()==0) {
			return "";
		}
		int k = Integer.parseInt(input[1]);
		char[] s = input[0].trim().toCharArray();
		int count = 0;
		for (int i=0; i<=s.length - k; i++) {
			if (s[i]=='-') {
				for (int j=0; j<k; j++) {
					if (s[i+j]=='-') {
						s[i+j] = '+';
					}
					else {
						s[i+j] = '-';
					}
				}
				count++;
			}
		}
		for (int i=s.length-1; i>=0; i--) {
			if (s[i]=='-') {
				return "IMPOSSIBLE";
			}
		}
		return Integer.toString(count);
	}
}