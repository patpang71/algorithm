package com.ppang;

import java.util.*;

public class Movie {
	private int id;
	private double rate;
	private List<Movie> similarMovies;
	
	public Movie(int id, double r) {
		this.id = id;
		rate = r;
		similarMovies = new ArrayList<Movie>();
	}
	
	public int getID() {
		return id;
	}
	public double getRate() {
		return rate;
	}
	public List<Movie> getSimilar() {
		return similarMovies;
	}
}
