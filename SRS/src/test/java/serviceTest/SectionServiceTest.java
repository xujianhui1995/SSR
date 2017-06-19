package serviceTest;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import dao.DaoFactory;
import model.Section;
import service.SectionService;

public class SectionServiceTest {
	private SectionService sectionservice;
	@Before
	public void loan() {
		// TODO Auto-generated method stub
		sectionservice=new SectionService(DaoFactory.createSectioneDao());
	}
	@Test
	public void findAllSections() {
		// TODO Auto-generated method stub
		
		HashMap<String, Section> sections=sectionservice.findAllSections();	
		for(HashMap.Entry<String, Section> entry: sections.entrySet())
        {
			System.out.println(entry.getValue()+entry.getKey());
		}
	}
}
