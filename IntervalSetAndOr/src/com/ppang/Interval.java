package com.ppang;

public class Interval {
	int start;
	int end;
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	public Interval(Interval a) {
		this.start = a.start;
		this.end = a.end;
	}
	
	@Override
	public String toString() {
		return "[" + Integer.toString(start) + ", " + Integer.toString(end) + "]";
	}
}
