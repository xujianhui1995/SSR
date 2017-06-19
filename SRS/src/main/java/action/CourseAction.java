package action;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import model.Course;
import model.CourseCatalog;
import service.CourseService;

public class CourseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String execute(){
		CourseService courseservice=new CourseService(DaoFactory.createCourseDao());
		CourseCatalog courseCatalog= courseservice.getCourseCatalog();
		HashMap<String, Course> courses=new HashMap<String, Course>();
		courses=courseCatalog.getCourses();
		Gson gson = new GsonBuilder().create();
		String s2 = gson.toJson(courses);  
        System.out.println(s2);  
		return "success";
    }
}
