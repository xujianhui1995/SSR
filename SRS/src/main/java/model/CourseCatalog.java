package model;

import java.util.*;

public class CourseCatalog {

	public HashMap<String, Course> courses;
	
	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}

	public CourseCatalog() {

		courses = new HashMap<String, Course>();
	}

	public CourseCatalog(HashMap<String, Course> courses) {

		this.courses = courses;
	}

	public void display() {

		for (Course c : courses.values()) {
			c.display();
			System.out.println();
		}
	}

	public void addCourse(Course c) {
		String key = c.getCourseNo();
		courses.put(key, c);
	}
	
	public void delCourse(Course c) {
		String key = c.getCourseNo();
		courses.remove(key, c);
	}
	
	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}

	public boolean isEmpty() {
		if (courses.size() == 0)
			return true;
		else
			return false;
	}
}
