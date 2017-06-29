package serviceTest;

import org.junit.Before;
import org.junit.Test;

import action.CourseAction;
import dao.DaoFactory;
import daoImpl.mysql.CourseDaoImpl;
import model.Course;
import model.CourseCatalog;
import service.CourseService;

public class CourseServiceTest {
	CourseService courseservice;
	CourseCatalog courseCatalog;

	@Before
	public void load() {
		// TODO Auto-generated constructor stub
		courseservice = new CourseService(DaoFactory.createCourseDao());
		courseCatalog = courseservice.getCourseCatalog();
	}

	@Test
	public void findCourse() {
		// TODO Auto-generated method stub
		courseservice.getCourseCatalog();

		Course course = new Course("11-11", "ooad", 3.0);

		// courseservice.addCourse(course);

		courseservice.delCourse(course);

	}

	@Test
	public void actiontest() {
		// TODO Auto-generated method stub
		CourseAction a = new CourseAction();
		a.findAll();
		

	}

	@Test
	public void testdao() {
		// TODO Auto-generated method stub
		CourseDaoImpl c = new CourseDaoImpl();
		c.findAll().display();
		// DBUtil.getMysqlConnection();
		// Course course=new Course("11-11", "ooad", 3.0);
		// c.addCourse(course);
	}
}
