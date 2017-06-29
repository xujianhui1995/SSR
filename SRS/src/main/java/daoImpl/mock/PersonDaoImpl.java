package daoImpl.mock;

import java.util.HashMap;
import dao.PersonDao;
import model.Professor;
import model.Student;

public class PersonDaoImpl implements PersonDao {

	@Override
	public HashMap<String, Professor> findAllProfessors() {		
		HashMap<String, Professor> professors = new HashMap<String, Professor>();	
		Professor p1, p2, p3;
		p1 = new Professor("Jacquie Barker", "123-45-6789", "Adjunct Professor", "Information Technology");
		professors.put(p1.getSsn(), p1);
		p2 = new Professor("John Smith", "567-81-2345", "Full Professor", "Chemistry");
		professors.put(p2.getSsn(), p2);
		p3 = new Professor("Snidely Whiplash", "987-65-4321", "Full Professor", "Physical Education");
		professors.put(p3.getSsn(), p3);		
		return professors;
	}

	@Override
	public HashMap<String, Student> findAllStudents() {
		HashMap<String, Student> Students = new HashMap<String, Student>();			
		Student s1 = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");
		Student s2 = new Student("Fred Schnurd", "222-22-2222", "Information Technology", "Ph. D.");
		Student s3 = new Student("Mary Smith", "333-33-3333", "Physics", "B.S.");
		Students.put(s1.getSsn(), s1);
		Students.put(s2.getSsn(), s2);
		Students.put(s3.getSsn(), s3);
		return Students;
	}

	@Override
	public boolean addProfessor(String ssn, String name, String title, String department) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProfessor(String ssn) {
		// TODO Auto-generated method stub
		return false;
	}

}
