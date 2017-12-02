/**
 * 
 */
package com.ppang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.*;


/**
 * @author ppang
 *
 */
public class NumberOfIsland {
	public final boolean T = true;
	public final boolean F = false;
	
	public static int numberOfIsland(boolean[][] bitmap) {
		if (bitmap==null || bitmap.length==0 || bitmap[0].length==0) {
			return 0;
		}
		int count = 0;
		for (int i=0; i<bitmap.length; i++) {
			for (int j=0; j<bitmap[0].length; j++) {
				if (bitmap[i][j]) {
					helper(bitmap, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	private static void helper(boolean[][] bitmap, int x, int y) {
		bitmap[x][y] = false;
		int[] dx = new int[] {-1, 1, 0, 0};
		int[] dy = new int[] {0, 0, -1, 1};
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx>=0 && nx<bitmap.length && ny>=0 && ny<bitmap[0].length && bitmap[nx][ny]) {
				helper(bitmap, nx, ny);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JUnitCore.main("com.ppang.NumberOfIsland");
	}
	
	@Test
	public void testFirst() {
		boolean[][] bitmap = 
				new boolean[][] { {F, T, T, F, F},
			{F, F, T, F, F},
			{F, F, F, T, T},
			{F, T, F, T, F} 					
		};
		assertEquals(3, NumberOfIsland.numberOfIsland(bitmap));
	}
	
	@Test
	public void testFileInput() {
		String filename = "input2.txt";
		List<List<Boolean>> input = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] curline = line.split(",");
				List<Boolean> tmp = new ArrayList<Boolean>();				
				for (String w : curline) {
					if (w.trim().equals("F")) {
						tmp.add(false);
					}
					else {
						tmp.add(true);
					}
				}
				input.add(tmp);
			}
			
			int m = input.size();
			int n = input.get(0).size();
			boolean[][] bitmap = new boolean[m][n];
			for (int i=0; i<input.size(); i++) {
				for (int j=0; j<input.get(i).size(); j++) {
					bitmap[i][j] = input.get(i).get(j);
				}
			}
			assertEquals(3, NumberOfIsland.numberOfIsland(bitmap));
			
		} catch(FileNotFoundException e) {
			fail("File Not Found!!");
		} catch(IOException ioe) {
			fail("IO Exception!!");
		} finally {
			try {
				if (br!=null) {
					br.close();
				}
				if (fr!=null) {
					fr.close();
				}
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
