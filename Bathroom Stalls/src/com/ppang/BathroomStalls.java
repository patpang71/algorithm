/**
 * 
 */
package com.ppang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 * @author ppang
 *
 */
public class BathroomStalls {
	BufferedReader br;
	PrintWriter pw;
	int n;
	
	class Range {
		int start;
		int end;
		int size;
		public Range(int s, int e) {
			start = s;
			end = e;
			size = end - start + 1;
		}
	}
	
	private int[] solve(int m, int k) {
		PriorityQueue<Range> queue = new PriorityQueue<Range>(k, (a, b) -> {
			if (a.size==b.size) {
				return a.start - b.start;
			}
			return b.size - a.size;
		});
		int maxSpace = Integer.MIN_VALUE;
		int minSpace = Integer.MAX_VALUE;
		queue.offer(new Range(1, m));
		for (int i=0; i<k; i++) {
			Range cur = queue.poll();
			int mid = (cur.start + cur.end)/2;
			Range left = new Range(cur.start, mid-1);
			Range right = new Range(mid+1, cur.end);
			queue.offer(left);
			queue.offer(right);
			maxSpace = Math.max(left.size, right.size);
			minSpace = Math.min(left.size, right.size);
		}
		return new int[] {maxSpace, minSpace};
	}
	public void run(String fileName) {
		try {
			br = new BufferedReader(new FileReader(fileName + ".in"));
			pw = new PrintWriter(fileName + ".out");
			String nStr = br.readLine();
			n = Integer.parseInt(nStr);
			for (int i=0; i<n; i++) {
				String line = br.readLine();
				String[] input = line.split(" ");
				int[] result = solve(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
				// Case #1: 1 0
				pw.println("Case #" + (i+1) + ": " + result[0] + " " + result[1]);
			}
		}
		catch(IOException ioe) {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BathroomStalls c = new BathroomStalls();
		c.run("C-small-practice-2");
	}

}
