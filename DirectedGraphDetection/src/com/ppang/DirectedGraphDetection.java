package com.ppang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphDetection {
	
	static class Node {
		List<Integer> neighbors;
		public Node () {
			neighbors = new ArrayList<Integer>();
		}
	}
	
	public boolean hasCycle(Node[] graph) {
		if (graph==null || graph.length==0) {
			return false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] degree = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		for (int i=0; i<graph.length; i++) {
			for (Integer j : graph[i].neighbors) {
				degree[j]++;
			}
		}
		for (int i=0; i<graph.length; i++) {
			if (degree[i]==0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			visited[cur] = true;
			for (Integer neighbor : graph[cur].neighbors) {
				degree[neighbor]--;
				if (degree[neighbor]==0 && !visited[neighbor]) {
					queue.offer(neighbor);
				}
			}
		}
		
		for (int i=0; i<graph.length; i++) {
			if (degree[i]>0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfNode = 4;
		Node[] graph = new Node[noOfNode];
		DirectedGraphDetection dg = new DirectedGraphDetection();
		for (int i=0; i<noOfNode; i++) {
			graph[i] = new DirectedGraphDetection.Node();
		}
		graph[0].neighbors.add(1);
		graph[1].neighbors.add(2);
		graph[1].neighbors.add(3);
		graph[2].neighbors.add(0);
		System.out.println(dg.hasCycle(graph));
	}

}
