package service;

import java.util.List;

import dao.ScheduleDao;
import model.EnrollmentStatus;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;

public class SectionService {
	private ScheduleDao scheduleDao;

	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public SectionService(ScheduleDao scheduleDao) {
		this.setScheduleDao(scheduleDao);
	}
	/*
	 * 方法
	 */

	public List<ScheduleOfClasses> findAll() {
		return scheduleDao.getScheduleOfClass();
	}

	public List<ScheduleOfClasses> findAllByStudent(String studentSsn) {
		return scheduleDao.findAllByStudent(studentSsn);
	}

	public Section getSectionBySectionNo(String FullNo) {
		return scheduleDao.getSectionBySectionNo(FullNo);
	}

	public EnrollmentStatus enroll(Section section, Student student) {
		return scheduleDao.enroll(section, student);
	}

}
