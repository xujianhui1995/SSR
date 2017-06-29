package daoImpl.mock;

import java.util.HashMap;
import java.util.Map;

import dao.CourseDao;
import model.Course;
import model.CourseCatalog;

public class CourseDaoImpl implements CourseDao {
	HashMap<String, Course> courses = new HashMap<String, Course>();
	Course c1, c2, c3, c4, c5;
	CourseCatalog coursecatlog=new CourseCatalog();
	public CourseDaoImpl() {
		// TODO Auto-generated constructor stub
		c1 = new Course("CMP101", "Beginning Computer Technology", 3.0);
		c2 = new Course("OBJ101", "Object Methods for Software Development", 3.0);
		c3 = new Course("CMP283", "Higher Level Languages (Java)", 3.0);
		c4 = new Course("CMP999", "Living Brain Computers", 3.0);
		c5 = new Course("ART101", "Beginning Basketweaving", 3.0);
		// 先修课程
		c2.addPrerequisite(c1);
		courses.put(c1.getCourseNo(), c1);
		courses.put(c2.getCourseNo(), c2);
		courses.put(c3.getCourseNo(), c3);
		courses.put(c4.getCourseNo(), c4);
		courses.put(c5.getCourseNo(), c5);
		
		coursecatlog.setCourses(courses);
	}
	
	public HashMap<String, Course> findAllMap() {
		return courses;
	}
	
	@Override
	public CourseCatalog findAll() {
//		coursecatlog.display();
		return coursecatlog;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courses.put(course.getCourseNo(), course);
		coursecatlog.setCourses(courses);
//		coursecatlog.display();

	}

	@Override
	public void delCourse(Course course) {
		// TODO Auto-generated method stub
		courses.remove(course.getCourseNo());
		coursecatlog.setCourses(courses);
//		coursecatlog.display();

	}

	

}
