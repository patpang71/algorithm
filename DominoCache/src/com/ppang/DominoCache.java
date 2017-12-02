package com.ppang;

import java.util.Map;

public class DominoCache {
	public Map<User, StripePlan> cache;
	
	public boolean insertUser(User u) {
		if (cache.isEmpty() || !cache.containsKey(u)) {
			cache.put(u, null);
		}
		else if (cache.containsKey(u)) {
			
		}
	}
	
	
	public void getPlanForUser() {
		// look at the map and see if the entry does not have a StripPlan, Call Strip to get the plan
		for (User u : cache.keySet()) {
			if (cache.get(u)==null) {
				// Call Stripe API to get Stripe Plan
				StripePlan plan = new StripePlan("1234");
				cache.put(u, plan);
			}
		}
	}
	
	public StripePlan getPlan(User user) {
		StripePlan plan = cache.get(user);
		return plan;
	}
	
}
