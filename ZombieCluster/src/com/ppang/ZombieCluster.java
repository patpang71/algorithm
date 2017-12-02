package com.ppang;

import java.util.Arrays;

public class ZombieCluster {

	static class UnionFind {
		int[] father;
		int n;
		public UnionFind(int n) {
			father = new int[n];
			for (int i=0; i<n; i++) {
				father[i] = i;
			}
		}
		
		public int find(int a) {
			int parent = a;
			while (parent!=father[parent]) {
				parent = father[parent];
			}
			int child = a;
			while (child!=father[child]) {
				int temp = father[child];
				father[child] = parent;
				child = temp;
			}
			return parent;
		}
		
		public void union(int a, int b) {
			int root_a = find(a);
			int root_b = find(b);
			if (root_a!=root_b) {
				father[root_b] = root_a;
			}
		}
	}
	
	public int countCluster(String[] zombies) {
		if (zombies==null || zombies.length==0) {
			return 0;
		}
		if (zombies.length!= zombies[0].length()) {
			return 0;
		}
		int n = zombies.length;
		UnionFind uf = new UnionFind(n);
		for (int i=0; i<zombies.length; i++) {
			for (int j=0; j<zombies[i].length(); j++) {
				char cur = zombies[i].charAt(j);
				if (cur=='1') {
					uf.union(i, j);
				}
			}
		}
		Arrays.sort(uf.father);
		int current = uf.father[0];
		int count = 1;
		for (int i=1; i<uf.father.length; i++) {
			if (current!=uf.father[i]) {
				count++;
				current = uf.father[i];
			}
		}
		if (current!=uf.father[uf.father.length-2]) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] zombies = new String[] { "11000", "11000", "00100", "00011", "00011" };
		ZombieCluster zc = new ZombieCluster();
		System.out.println(zc.countCluster(zombies));
	}

}
