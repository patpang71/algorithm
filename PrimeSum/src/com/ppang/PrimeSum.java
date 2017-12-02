package com.ppang;

import java.util.Arrays;
import java.util.TreeMap;

/*
 * 今天店面，没面好，估计挂了：第一题：计算小于num的prime的sum，follow up：如果需要request 1b次，
 * 你如何优化，我说了一个先把所有的结果算出来，面试官不满意。然后给了面试官提示加入7 8 9 10，
 * 和都是17.最后搞了一个把数值都存在treemap中。
 */
public class PrimeSum {

	TreeMap<Integer, Integer> tmap;
	public int primeSum(int n) {
		if (tmap==null) {
			tmap = new TreeMap<Integer, Integer>();
		}
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for (int i=2; i<n/2; i++) {
			for (int j=1; i * j <= n; j++) {
				isPrime[i * j] = false;
			}
		}
		int sum = 0;
		for (int i=2; i<=n; i++) {
			if (isPrime[i]) {
				sum = sum + i;
				tmap.put(i, sum);
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeSum ps = new PrimeSum();
		System.out.println(ps.primeSum(18));
	}

}
