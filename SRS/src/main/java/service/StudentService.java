package service;

import dao.SectionDao;
import dao.StudentDao;
import model.EnrollmentStatus;
import model.Section;
import model.Student;
import model.Transcript;

public class StudentService {
	StudentDao studentdao;
	SectionDao sectiondao;
	
	public StudentService(StudentDao createStudentDao) {
		// TODO Auto-generated constructor stub
		this.setStudentdao(createStudentDao);
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	public SectionDao getSectiondao() {
		return sectiondao;
	}
	public void setSectiondao(SectionDao sectiondao) {
		this.sectiondao = sectiondao;
	}
	/*
	 * 方法
	 */
	public Student findBySsn(String studentSsn) {
		return studentdao.findBySsn(studentSsn);
	}

	public Transcript findTranscript(Student student) {
		return null;
	}
	
	
}