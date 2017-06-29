package daoImpl.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SectionDao;
import model.Course;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;

public class SectionDaoImpl implements SectionDao {
	Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;
	Course c;
	Map<String, Course> allCourses;
	HashMap<String, Section> sections;
	List<Section> sectionlist=new ArrayList<Section>();
	ScheduleOfClasses scheduleOfClasses1 = new ScheduleOfClasses("2005-1");
	ScheduleOfClasses scheduleOfClasses2 = new ScheduleOfClasses("2005-2");

	public SectionDaoImpl() {
		sections = new HashMap<String, Section>();
		allCourses = new CourseDaoImpl().findAllMap();
		c = allCourses.get("CMP101");
		sec1 = new Section(1, 'M', "8:10 - 10:00 PM", c, "GOVT101", 30);
		sections.put(c.getCourseNo() + "-" + sec1.getSectionNo(), sec1);
		sec2 = new Section(2, 'W', "6:10 - 8:00 PM", c, "GOVT202", 30);
		sections.put(c.getCourseNo() + "-" + sec2.getSectionNo(), sec2);

		c = allCourses.get("OBJ101");
		sec3 = new Section(1, 'R', "4:10 - 6:00 PM", allCourses.get("OBJ101"), "GOVT105", 25);
		sections.put(c.getCourseNo() + "-" + sec3.getSectionNo(), sec3);
		sec4 = new Section(2, 'T', "6:10 - 8:00 PM", allCourses.get("OBJ101"), "SCI330", 25);
		sections.put(c.getCourseNo() + "-" + sec4.getSectionNo(), sec4);

		c = allCourses.get("CMP283");
		sec5 = new Section(1, 'M', "6:10 - 8:00 PM", allCourses.get("CMP283"), "GOVT101", 20);
		sections.put(c.getCourseNo() + "-" + sec5.getSectionNo(), sec5);

		c = allCourses.get("CMP999");
		sec6 = new Section(1, 'R', "4:10 - 6:00 PM", allCourses.get("CMP999"), "SCI241", 15);
		sections.put(c.getCourseNo() + "-" + sec6.getSectionNo(), sec6);

		c = allCourses.get("ART101");
		sec7 = new Section(1, 'M', "4:10 - 6:00 PM", allCourses.get("ART101"), "ARTS25", 40);
		sections.put(c.getCourseNo() + "-" + sec7.getSectionNo(), sec7);
		scheduleOfClasses1.addSection(sec1);
		scheduleOfClasses1.addSection(sec2);
		scheduleOfClasses1.addSection(sec3);
		scheduleOfClasses2.addSection(sec4);
		scheduleOfClasses2.addSection(sec5);
		scheduleOfClasses2.addSection(sec6);
		scheduleOfClasses2.addSection(sec7);

	}

	@Override
	public List<Section> findAll() {
		sectionlist.add(sec1);
		sectionlist.add(sec2);
		sectionlist.add(sec3);
		sectionlist.add(sec4);
		sectionlist.add(sec5);
		sectionlist.add(sec6);
		sectionlist.add(sec7);
		return sectionlist;
	}

	@Override
	public HashMap<String, Section> findAllSections() {
		System.out.println(sec1);
		return sections;
	}

	@Override
	public HashMap<String, Section> findBySemester(String semester) {
		HashMap<String, Section> findBySemestersetions = new HashMap<String, Section>();
		for (Map.Entry<String, Section> entry : sections.entrySet()) {
			if (entry.getValue().getOfferedIn().getSemester() == semester)
				findBySemestersetions.put(entry.getKey(), entry.getValue());
		}
		return findBySemestersetions;
	}

	@Override
	public HashMap<String, Section> findByStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
