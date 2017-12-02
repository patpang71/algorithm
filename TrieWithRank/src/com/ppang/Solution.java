/**
 * 
 */
package com.ppang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ppang
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputFile = "input.txt";
		String prefixFile = "prefix.txt";
		String outputFile = "output.txt";
		//String message = "";
		Map<String, Integer> map = null;
		List<String> prefix = null;
		Solution sol = new Solution();
		TrieTree tree = new TrieTree();
		try {
			Files.deleteIfExists((new File(outputFile)).toPath());
			map = sol.readFromFile(inputFile);
			prefix = sol.readFromPrefixFile(prefixFile);
			for (String w : map.keySet()) {
				tree.insert(w, map.get(w));
			}
			
			for (String pref : prefix) {
				List<TrieNode> res = tree.findWithPrefix(pref);
				Collections.sort(res, (a, b) -> a.rank - b.rank);
				String content = pref + ":" + "\n";
				for (TrieNode node : res) {
					content = content + node.word + " " 
							+ Integer.toString(node.rank) + "\n";
				}
				content = content + "\n";
				sol.writeToFile(outputFile, content);
			}
		}
		catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			fnf.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	
	public void writeToFile(String filename, String content) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(filename, true));
		pw.write(content);
		pw.close();
	}
	
	public List<String> readFromPrefixFile(String filename) throws IOException, FileNotFoundException {
		BufferedReader br = null;
		FileReader fr = new FileReader(filename);
		List<String> list = new ArrayList<String>();
		br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine())!=null) {
			list.add(line.trim());
		}
		br.close();
		fr.close();
		return list;
	}
	
	public Map<String, Integer> readFromFile(String filename) throws IOException, FileNotFoundException {
		BufferedReader br = null;
		FileReader fr = new FileReader(filename);
		Map<String, Integer> map = new HashMap<String, Integer>();
		br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine())!=null) {
			String[] element = line.split(" ");
			String w = element[0];
			int i=1;
			while (i<element.length && element[i].trim().equals("")) {
				i++;
			}
			int freq = Integer.parseInt(element[i].trim());
			map.put(w, freq);
		}
		br.close();
		fr.close();
		return map;
	}

}
