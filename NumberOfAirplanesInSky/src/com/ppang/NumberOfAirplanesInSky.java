package com.ppang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfAirplanesInSky {

	static class Interval {
		int start;
		int end;
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	static class Point {
		int time;
		boolean isUp;
		public Point(int t, boolean up) {
			time = t;
			isUp = up;
		}
	}
	
	public int maxPlane(List<Interval> intervals) {
		// return the max no of plane in 1 instance
		List<Point> points = new ArrayList<Point>();
		
	}
	
	public int noOfPlane(List<Interval> intervals, int point) {
		// This is to count how many interval contains the point
		if (intervals==null || intervals.size()==0) {
			return 0;
		}
		Collections.sort(intervals, (a, b) -> 
		{ 
			if (a.start==b.start) {
				return a.end - b.end;
			}
			return a.start - b.start;
		});
		int count = 0;
		for (Interval interval : intervals) {
			if (interval.start <= point && interval.end >= point) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
