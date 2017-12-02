package com.ppang;

import java.util.*;

public class Employee {
	private String name;
	private List<Employee> peopleUnder;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public List<Employee> getPeopleUnder() {
		return peopleUnder;
	}
}
