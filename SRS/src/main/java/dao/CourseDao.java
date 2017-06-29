package dao;

import model.Course;
import model.CourseCatalog;

public interface CourseDao {
	
	public CourseCatalog findAll();

	public void addCourse(Course course);

	public void delCourse(Course course);

}
