package daoImpl.mock;

import java.util.HashMap;
import dao.ScheduleDao;
import model.ScheduleOfClasses;
import model.Section;

public class ScheduleDaoImpl implements ScheduleDao {
	@Override
	public ScheduleOfClasses getScheduleOfClass(String semester) {
		// TODO Auto-generated method stub
		ScheduleOfClasses scheduleOfClasses = new ScheduleOfClasses(semester);
		HashMap<String, Section> sections=(new SectionDaoImpl()).findBySemester(semester);		        
		scheduleOfClasses.setSectionsOffered(sections);
		return scheduleOfClasses;		
	}
	

}
