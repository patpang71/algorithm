package com.ppang;

import java.util.*;

public class EmployeeMap {
	public Map<String, List<String>> getEmployeeMap(Map<String, String> empMgr) {
		Map<String, List<String>> mgrEmp = new HashMap<String, List<String>>();
		for (String emp : empMgr.keySet()) {
			String mgr = empMgr.get(emp);
			List<String> temp = null;
			if (mgrEmp.containsKey(mgr)) {
				temp = mgrEmp.get(mgr);
				temp.add(emp);
			}
			else {
				temp = new ArrayList<String>();
				temp.add(emp);
			}
			mgrEmp.put(mgr, temp);
		}
		return mgrEmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
