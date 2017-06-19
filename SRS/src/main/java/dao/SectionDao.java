package dao;

import java.util.HashMap;
import java.util.List;

import model.Section;

public interface SectionDao {
	public HashMap<String,Section> findAllSections();
	public List<Section> findAll();
	public HashMap<String,Section> findBySemester(String semester);
}
