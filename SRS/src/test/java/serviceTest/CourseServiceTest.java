package serviceTest;

import org.junit.Before;
import org.junit.Test;

import dao.DaoFactory;
import model.CourseCatalog;
import service.CourseService;

public class CourseServiceTest {
	CourseService courseservice;
	CourseCatalog courseCatalog;
	@Before
	public void load() {
		// TODO Auto-generated constructor stub
		courseservice= new CourseService(DaoFactory.createCourseDao());
		courseCatalog= courseservice.getCourseCatalog();
	}
	@Test
	public void findCourse() {
		// TODO Auto-generated method stub
		courseservice.findCourse("CMP101").display();;

	}
	

}
