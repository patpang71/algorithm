package com.ppang;

import java.util.*;

public class MovieNetwork {
	
	public List<Movie> find(Movie movie, int n) {
		List<Movie> ans = new ArrayList<Movie>();
		if (movie==null || n<=0) {
			return ans;
		}
		PriorityQueue<Movie> queue = new PriorityQueue<Movie>(n, (a, b) -> (int)(b.getRate() - a.getRate()));
		queue.offer(movie);
		while (!queue.isEmpty()) {
			Movie cur = queue.poll();
			if (cur.getID() != movie.getID()) {
				ans.add(cur);
				if (ans.size()==n) {
					break;
				}
			}
			for (Movie m : cur.getSimilar()) {
				queue.offer(m);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie root = new Movie(1, 2);
		Movie m2 = new Movie(2, 1);
		Movie m3 = new Movie(3, 3);
		Movie m4 = new Movie(4, 2);
		Movie m5 = new Movie(5, 6);
		Movie m6 = new Movie(6, 7);
		root.getSimilar().add(m2);
		root.getSimilar().add(m3);
		m2.getSimilar().add(m4);
		m2.getSimilar().add(m5);
		m2.getSimilar().add(m6);
		m6.getSimilar().add(m3);
		MovieNetwork mn = new MovieNetwork();
		List<Movie> ans = mn.find(root, 3);
		for (Movie m : ans) {
			System.out.println("Movie ID: " + m.getID() + " Rank: " + m.getRate());
		}
	}

}
