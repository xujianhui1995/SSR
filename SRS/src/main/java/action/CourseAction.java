package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import model.Course;
import model.CourseCatalog;
import service.CourseService;

public class CourseAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String result;
	String courseNo;

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	CourseService courseservice = new CourseService(DaoFactory.createCourseDao());

	CourseCatalog courseCatalog = courseservice.getCourseCatalog();
	public HashMap<String, Course> courses = new HashMap<String, Course>();

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String findAll() {
		try {
			courses = courseCatalog.getCourses();
			Gson gson = new Gson();
			result = gson.toJson(courses.values());
//			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String addCourse() {
		/* 获取参数 */
		String courseNo = request.getParameter("courseNo");
		String courseName = request.getParameter("courseName");
		double credits = Double.parseDouble(request.getParameter("credits"));
		String prerequisitescourseNo = request.getParameter("prerequisitescourseNo");

		Course course = new Course(courseNo, courseName, credits);
		course.addPrerequisite(courseservice.findCourse(prerequisitescourseNo));
		courseservice.addCourse(course);
		return "success";
	}

	public String delCourse() {
//		System.out.println(courseNo);
		courseservice.delCourse(courseservice.findCourse(courseNo));
		return "success";
	}
}
