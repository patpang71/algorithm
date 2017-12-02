package com.ppang;

import java.util.*;

public class MenuRecommendation {

	static class Recommendation {
		String name;
		String recommendation;
		public Recommendation(String n, String r) {
			name = n;
			recommendation = r;
		}
	}
	Map<String, List<String>> menuMap;
	
	public String[][] provideRecommendation(String[][] menu, String[][] personalPreference) {
		if (menu==null || menu.length==0 || menu[0].length==0 || personalPreference==null || 
				personalPreference.length==0 || personalPreference[0].length==0) {
			return new String[0][0];
		}
		List<Recommendation> recommendations = new ArrayList<Recommendation>();
		menuMap = new HashMap<String, List<String>>();
		for (int i=0; i<menu.length; i++) {
			String type = menu[i][1];
			String menuItem = menu[i][0];
			List<String> items = null;
			if (menuMap.containsKey(type)) {
				items = menuMap.get(type);
				if (!items.contains(menuItem)) {
					items.add(menuItem);
				}
			}
			else {
				items = new ArrayList<String>();
				items.add(menuItem);
			}
			menuMap.put(type, items);
		}
		
		for (int i=0; i<personalPreference.length; i++) {
			String name = personalPreference[i][0];
			String type = personalPreference[i][1];
			List<String> items = null;
			items = menuMap.get(type);
			for (String item : items) {
				Recommendation r = new Recommendation(name, item);
				recommendations.add(r);
			}
		}
		
		String[][] ans = new String[recommendations.size()][2];
		int idx = 0;
		for (Recommendation r : recommendations) {
			ans[idx][0] = r.name;
			ans[idx++][1] = r.recommendation;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] menu = new String[][] {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}};
		String[][] personalPreference = new String[][] {{"Peter", "Italian"}, {"Adam", "American"}};
		MenuRecommendation menuRecommenation = new MenuRecommendation();
		String[][] ans = menuRecommenation.provideRecommendation(menu, personalPreference);
		for (int i=0; i<ans.length; i++) {
			System.out.println("Name: " + ans[i][0] + "  Recommendation: " + ans[i][1]);
		}
	}

}
