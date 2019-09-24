package com.vishal.equalshashcode;

import java.util.HashMap;
import java.util.Map;

public class EmployeeAddress {

	public static void main(String[] args) {
		Map<Employee, Address> employeeMap = new HashMap<Employee, Address>();
		Employee e1 = new Employee(101, "vishal");
		Employee e2 = new Employee(102, "sahil");
		Address a1 = new Address("Abohar", "Punjab");
		Address a2 = new Address("Chandigarh", "Chandigarh");
		employeeMap.put(e1, a1);
		employeeMap.put(e2, a2);
		System.out.println(getAddress(employeeMap, new Employee(101, "vishal")));
	}
	
	private static String getAddress(Map<Employee, Address> map, Employee e) {
		return map.get(e).getCity() + ", " + map.get(e).getState();
	}

}
