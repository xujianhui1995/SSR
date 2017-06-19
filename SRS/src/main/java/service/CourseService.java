package service;

import model.Course;
import model.CourseCatalog;
import dao.CourseDao;

public class CourseService {
	
	private static CourseCatalog  courses;
	private CourseDao courseDao = null;
	
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	public CourseService(CourseDao dao){
		this.setCourseDao(dao);
		courses = new CourseCatalog(dao.findAll());
	}

	public CourseCatalog getCourseCatalog() {
		return courses;
	}
	
	public Course findCourse(String courseNo){
	   return courses.findCourse(courseNo);
	}

	
}
