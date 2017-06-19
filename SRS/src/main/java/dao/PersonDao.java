package dao;

import java.util.HashMap;

import model.Professor;
import model.Student;;

public interface PersonDao {
	
	public HashMap<String, Professor> findAllProfessors();
	public HashMap<String, Student> findAllStudents();

}
