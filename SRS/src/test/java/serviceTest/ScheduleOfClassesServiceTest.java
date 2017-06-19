package serviceTest;

import java.util.HashMap;

import org.junit.Test;

import dao.DaoFactory;
import daoImpl.mock.ScheduleDaoImpl;
import model.ScheduleOfClasses;
import model.Section;
import service.ScheduleOfClassesService;

public class ScheduleOfClassesServiceTest {
	
	
	@Test
	public void test(){
		String semester = "SP2005-1";		
		ScheduleOfClassesService ScheduleOfClassesService=new 
				ScheduleOfClassesService(DaoFactory.createScheduleDao());
		ScheduleOfClasses soc=ScheduleOfClassesService.getScheduleOfClasses(semester);
		System.out.println("该学期一共有："+soc.getSectionsOffered().size()+"门课");

		HashMap<String, Section> sections=soc.getSectionsOffered();		
		for(HashMap.Entry<String, Section> entry: sections.entrySet())
        {
			System.out.println("选课号："+entry.getKey());
		}
	}	
	@Test
	public void vv() {
		ScheduleDaoImpl s=new ScheduleDaoImpl();
		System.out.println(s.getScheduleOfClass("SP2005-1").getSectionsOffered().size());
	}
}
