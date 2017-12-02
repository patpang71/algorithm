package com.ppang;

import java.util.*;

public class BlockAndGuard {
	static class Node {
		int x;
		int y;
		int dist;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			dist = d;
		}
	}
	
	int[] dx = new int[] {-1, 1, 0, 0};
	int[] dy = new int[] {0, 0, -1, 1};
	public int getJewelry (char[][] rooms) {
		if (rooms==null || rooms.length==0 || rooms[0].length==0) {
			return 0;
		}
		int[][] distances = new int[rooms.length][rooms[0].length];
		Arrays.fill(distances, Integer.MAX_VALUE);
		PriorityQueue<Node> queue = new PriorityQueue<Node>((a, b) -> a.dist - b.dist);
		for (int i=0; i<rooms.length; i++) {
			for (int j=0; j<rooms[0].length; j++) {
				if (rooms[i][j]=='G') {
					queue.offer(new Node(i, j, 0));
				}
			}
		}
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			distances[cur.x][cur.y] = cur.dist;
			if (rooms[cur.x][cur.y]=='J') {
				return cur.dist;
			}
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx<0 || nx>=rooms.length || ny<0 || ny>=rooms[0].length || rooms[nx][ny]=='B') {
					continue;
				}
				else if (rooms[nx][ny]=='W') {
					queue.offer(new Node(nx, ny, cur.dist+3));
				}
				else {
					queue.offer(new Node(nx, ny, cur.dist+1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] rooms = new char[][] {{' ', ' ', 
	}

}
