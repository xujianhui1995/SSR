package serviceTest;

import org.junit.Before;
import org.junit.Test;

import dao.DaoFactory;
import model.Professor;
import service.PersonService;

public class PersonServiceTest {
	PersonService ps;
	@Before
	public void loan() {
		// TODO Auto-generated method stub
		ps=new PersonService(DaoFactory.createPersonDao());
	}
	@Test
	public void add(){
		Professor prodessor=new Professor("111", "111", "111", "111");
		ps.addProfessor(prodessor);
	}
	@Test
	public void del(){
		ps.delProfessor("111");
	}
	@Test
	public void findall(){
		System.out.println(ps.findAllProfessors());
	}
}
