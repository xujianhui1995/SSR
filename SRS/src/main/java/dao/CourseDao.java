package dao;

import java.util.HashMap;
import model.Course;

public interface CourseDao {
	
	public HashMap<String, Course> findAll();

}
