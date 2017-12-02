package com.ppang;

import java.util.ArrayList;
import java.util.List;

public class IntervalSetAndOr {

	/*
	 * Given 2 sets of intervals.
. 1point3acres.com/bbs
Interval is defined with left and right border and discrete points, like [2, 3], [0, 0], etc.

Set of intervals is non intersected set of sorted intervals, for example: [0, 0], [2, 2], [5, 10] is a valid set of intervals, but :. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
* [0, 0], [1, 2] is not valid, because you can write it as [0, 2]. 
* [0, 2], [1, 5] is not valid as well, since these two intervals intersect.
. more info on 1point3acres.com
You need to find the AND operation of these two sets. For example:

1st set: [0, 2], [5, 10], [16, 20] [25, 26] [28, 30]
2nd set: [1, 5], [11, 12], [14, 18] [20, 23]. 1point3acres.com/bbs

AND Result: [1, 2], [5, 5], [16, 18], [20, 20]

OR . From 1point 3acres bbs

1st set: [0, 2], [6, 8], [16, 20]
2nd set: [1, 5], [12, 18], [20, 23]

[0,8], [12,23]
 
	 */

	public List<Interval> andOperation(List<Interval> a, List<Interval> b) {
		List<Interval> merge = new ArrayList<Interval>();
		int i=0;
		int j=0;
		Interval res = null;
		while (i<a.size() && j<b.size()) {
			if (a.get(i).end < b.get(j).end) {
				res = andMerge(a.get(i), b.get(j));
				i++;
				if (res!=null)
					merge.add(res);
			}
			else {
				res = andMerge(a.get(i), b.get(j));
				j++;
				if (res!=null)
					merge.add(res);
			}
		}
		while (j<b.size() && a.get(a.size()-1).end >= b.get(j).start) {
			res = andMerge(a.get(a.size()-1), b.get(j));
			j++;
		}
		while (i<a.size() && b.get(b.size()-1).end >= a.get(i).start) {
			res = andMerge(b.get(b.size()-1), a.get(i));
			i++;
		}
		if (merge.size()==1) {
			return merge;
		}
		for (i=1; i<merge.size(); ) {
			if (merge.get(i-1).end >= merge.get(i).start) {
				merge.get(i-1).start = Math.min(merge.get(i-1).start, merge.get(i).start);
				merge.get(i-1).end = Math.max(merge.get(i-1).end, merge.get(i).end);
				merge.remove(i);
				continue;
			}
			i++;
		}
		return merge;
	}
	
	private Interval andMerge(Interval a, Interval b) {
		if (a.start > b.start) {
			return andMerge(b, a);
		}
		if (a.end >= b.start) {
			return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
		}
		else {
			return null;
		}
	}
	
	public List<Interval> orOperation(List<Interval> a, List<Interval> b) {
		List<Interval> merge = new ArrayList<Interval>();
		int i=0;
		int j=0;
		while (i<a.size() && j<b.size()) {
			if (a.get(i).start < b.get(j).start) {
				merge = orMerge(merge, a.get(i++));
			}
			else {
				merge = orMerge(merge, b.get(j++));
			}
		}
		if (i>=a.size()) {
			while (j<b.size()) {
				merge = orMerge(merge, b.get(j++));
			}
		}
		else if (j>=b.size()) {
			while (i<a.size()) {
				merge = orMerge(merge, a.get(i++));
			}
		}
		return merge;
	}
	
	private List<Interval> orMerge(List<Interval> list, Interval a) {
		if (list.isEmpty()) {
			list = new ArrayList<Interval>();
			list.add(new Interval(a));
			return list;
		}
		if (list.size()==0) {
			list.add(new Interval(a));
			return list;
		}
		int last = list.size()-1;
		if (list.get(last).end+1 >= a.start) {
			list.get(last).start = Math.min(list.get(last).start, a.start);
			list.get(last).end = Math.max(list.get(last).end, a.end);
		}
		else {
			list.add(new Interval(a));
		}
		return list;
	}
	
	public static void main(String[] args) {
		/*
		1st set: [0, 2], [5, 10], [16, 20] [25, 26] [28, 30]
		2nd set: [1, 5], [11, 12], [14, 18] [20, 23]. 
		 */
		List<Interval> intervalA = new ArrayList<Interval>();
		intervalA.add(new Interval(0, 2));
		intervalA.add(new Interval(5, 10));
		intervalA.add(new Interval(16, 20));
		intervalA.add(new Interval(25, 26));
		intervalA.add(new Interval(28, 30));
		
		List<Interval> intervalB = new ArrayList<Interval>();
		intervalB.add(new Interval(1, 5));
		intervalB.add(new Interval(11, 12));
		intervalB.add(new Interval(14, 18));
		intervalB.add(new Interval(20, 23));
		
		IntervalSetAndOr intervalSetAndOr = new IntervalSetAndOr();
		List<Interval> orResult = intervalSetAndOr.orOperation(intervalA, intervalB);
		StringBuilder sb = new StringBuilder();
		for (Interval i : orResult) {
			sb.append(i.toString());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
		List<Interval> andResult = intervalSetAndOr.andOperation(intervalA, intervalB);
		sb = new StringBuilder();
		for (Interval i : andResult) {
			sb.append(i.toString());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	
}
