package dao;

import java.util.HashMap;

import model.Professor;
import model.Student;;

public interface PersonDao {
	
	public HashMap<String, Student> findAllStudents();
	public boolean addProfessor(String ssn,String name,String title,String department);
	public boolean delProfessor(String ssn);
	public HashMap<String, Professor> findAllProfessors();		


}
