/**
 * 
 */
package com.ppang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ppang
 *
 */
public class AutoComplete {

	BufferedReader br;
	PrintWriter pw;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "input.in";
		String outputFile = "output.txt";
		
		// read from Stdin
		Scanner in = new Scanner(System.in);
		inputFile = in.next();
		in.close();
		
		AutoComplete ac = new AutoComplete();
		ac.run(inputFile, outputFile);
	}
	

	public void run (String inputFile, String outputFile) {
		TrieTree tree = new TrieTree();
		try {
			br = new BufferedReader(new FileReader(inputFile));
			pw = new PrintWriter(new FileWriter(outputFile));
			List<String> prefixes = new ArrayList<String>();
			
			// read the 1st line for no of Words
			String noOfWordsStr = br.readLine();
			int noOfWord = Integer.parseInt(noOfWordsStr);
			
			// read the 2nd line for no of Prefixes
			String noOfPrefixStr = br.readLine();
			int noOfPrefix = Integer.parseInt(noOfPrefixStr);
			
			// read each word and then add to Trie Tree
			for (int i=0; i<noOfWord; i++) {
				String word = br.readLine();
				tree.insert(word, i+1);
			}
			
			// read all the prefixes
			for (int j=0; j<noOfPrefix; j++) {
				prefixes.add(br.readLine());
			}
			
			// run in the Trie Tree for the list and print out the result
			for (String pre : prefixes) {
				List<TrieNode> nodes = tree.findWithPrefix(pre);
				Collections.sort(nodes, (a, b) -> a.rank - b.rank);
				pw.println(pre + ":");
				for (int cnt=0; cnt<Math.min(nodes.size(), 5); cnt++) {
					pw.println(nodes.get(cnt).word + " (" + nodes.get(cnt).rank + ")");
				}
				pw.println();
			}
			
		}
		catch (IOException ioe) {
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

}
