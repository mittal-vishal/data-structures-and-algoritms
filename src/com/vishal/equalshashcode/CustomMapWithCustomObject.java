package com.vishal.equalshashcode;

import java.util.HashMap;
import java.util.Map;

public class CustomMapWithCustomObject {

	public static void main(String[] args) {
		Map<EmployeeObj, String> map = new HashMap<>();
		EmployeeObj e1 = new EmployeeObj(1);
		EmployeeObj e2  = new EmployeeObj(1);
		map.put(e1, "vishal");
		map.put(e2, "sahil");
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(map);
	}

}

class EmployeeObj{
	
	int id;

	public EmployeeObj(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeObj other = (EmployeeObj) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
