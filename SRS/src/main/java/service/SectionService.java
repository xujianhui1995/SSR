package service;

import java.util.HashMap;
import java.util.List;

import dao.SectionDao;
import model.Section;

public class SectionService {
	private SectionDao sectiondao;
	public SectionDao getSectiondao() {
		return sectiondao;
	}

	public void setSectiondao(SectionDao sectiondao) {
		this.sectiondao = sectiondao;
	}

	public SectionService(SectionDao sectiondao) {
		this.setSectiondao(sectiondao);
	}
	public HashMap<String,Section> findAllSections() {
		return sectiondao.findAllSections();
	}
	public List<Section> findAll() {
		return sectiondao.findAll();
	}
	public HashMap<String,Section> findBySemester(String semester) {
		return sectiondao.findBySemester(semester);
	}
	
}
