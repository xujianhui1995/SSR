package dao;

import java.util.HashMap;
import java.util.List;

import model.Section;
import model.Student;

public interface SectionDao {
	public HashMap<String,Section> findAllSections();
	public List<Section> findAll();
	public HashMap<String,Section> findBySemester(String semester);
	public HashMap<String, Section> findByStudent(Student student);
	
}
