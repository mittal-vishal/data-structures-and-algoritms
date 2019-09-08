package com.vishal.customsort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortByCustomComparator {

	public static void main(String[] args) {
		Student s1 = new Student(102, "Keshav");
		Student s2 = new Student(100, "Vishal");
		List<Student> studentList = new LinkedList<>();
		studentList.add(s1);
		studentList.add(s2);
		Collections.sort(studentList, new StudentComparator());
		for(Student s : studentList) {
			System.out.println(s.getName());
		}
	}

}
