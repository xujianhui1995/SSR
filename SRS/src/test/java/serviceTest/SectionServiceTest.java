package serviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import action.SectionAction;
import dao.DaoFactory;
import daoImpl.mysql.ScheduleDaoImpl;
import model.Course;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;
import service.ScheduleOfClassesService;
import service.SectionService;
import service.StudentService;

public class SectionServiceTest {
	Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;
	Course c;
	ScheduleOfClasses scheduleOfClasses;
	HashMap<String, Course> allCourses = new HashMap<String, Course>();
	HashMap<String, Section> sections = new HashMap<String, Section>();
	List<ScheduleOfClasses> schedule = new ArrayList<ScheduleOfClasses>();

	List<Section> sectionlist = new ArrayList<Section>();
	ScheduleOfClasses scheduleOfClasses2 = new ScheduleOfClasses("2005-2");

	@Test
	public void a() {
		ScheduleDaoImpl sh = new ScheduleDaoImpl();
		sh.getScheduleOfClass();
		System.out.println(sh.getScheduleOfClass());
		// HashMap<String, Section> sections=new HashMap<String, Section>();
		// HashMap<String, Section> se = new HashMap<String, Section>();
		// sec1.setOfferedIn(scheduleOfClasses1);
		// se.put(scheduleOfClasses1.getSemester(), sec1);
		// System.out.println(se);

		Gson gson = new Gson();
		String s = gson.toJson(sh.getScheduleOfClass());
		System.out.println(s);

	}

	@Test
	public void findAll() {
		SectionAction sa = new SectionAction();
		sa.findAll();
	}

	@Test
	public void findBySemester() {
		ScheduleOfClassesService schedule = new ScheduleOfClassesService(DaoFactory.createScheduleDao());
		List<ScheduleOfClasses> list = schedule.getScheduleOfClassesBySemester("2005-1");
		System.out.println(list.get(0).getSections().get(0).getFullSectionInfo());
	}

	@Test
	public void enroll() {
		// TODO Auto-generated method stub
//		SectionService se=new SectionService(DaoFactory.createScheduleDao());
//		Course course = new Course("CMP101", "Beginning Computer Technology", 3.0);
//		Section section = new Section(1, 'M', "8:10 - 10:00 PM", course, "GOVT101", 30);
//		Student student = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");
//		String s=section.getFullSectionNo();		
//		System.out.println(s);
//		System.out.println(s.substring(9, 10));
//
//		se.enroll(section, student);
		StudentService studentservice=new StudentService(DaoFactory.createStudentDao());
		Student s=studentservice.findBySsn("111-11-1111");
		System.out.println(s.getTranscript());
	}
	@Test
	public void enrollAction() {
		// TODO Auto-generated method stub
		SectionAction sa=new SectionAction();
//		sa.setSectionFullNo("CMP101 - 1");
//		sa.setStudentSsn("111-11-1111");
		sa.enroll();
	}
	@Test
	public void findAllByStudent() {
		// TODO Auto-generated method stub
		SectionService ss=new SectionService(DaoFactory.createScheduleDao());
		ss.findAllByStudent("111-11-1111");
		System.out.println(ss.findAllByStudent("111-11-1111"));
	}
}
