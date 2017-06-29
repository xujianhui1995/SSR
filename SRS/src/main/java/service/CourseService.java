package service;

import dao.CourseDao;
import model.Course;
import model.CourseCatalog;
import model.Section;

public class CourseService {

	private static CourseCatalog courses;
	private CourseDao courseDao = null;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public CourseService(CourseDao dao) {
		this.setCourseDao(dao);
		courses =dao.findAll();
	}

	public CourseCatalog getCourseCatalog() {
		return courses;
	}

	public Course findCourse(String courseNo) {
		return courses.findCourse(courseNo);
	}

	public Section scheduleSection(Course course) {
		Section s = null;
		course.addSection(s);
		return s;
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.addCourse(course);
	}

	public void delCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.delCourse(course);

	}

}
