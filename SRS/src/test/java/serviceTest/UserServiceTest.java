package serviceTest;

import org.junit.Test;

import dao.DaoFactory;
import daoImpl.mysql.PersonDaoImpl;
import daoImpl.mysql.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceTest {
	private UserDaoImpl userdao;

	public UserDaoImpl getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDaoImpl userdao) {
		this.userdao = userdao;
	}
	
	@Test
	public void login() {
		// TODO Auto-generated method stub
//		User u=new User("lee", "123", "student");
		UserService us=new UserService(DaoFactory.createUserDao());
		User user=new User("111-11-1111","123");
		boolean b=us.login(user);
		System.out.println(b);
	}
	@Test
	public void professor(){
		PersonDaoImpl p=new PersonDaoImpl();
//		System.out.println(p.findAllProfessors());
//		p.addProfessor("123", "123", "123", "123");
//		p.delProfessor("123");
//		p.addStudent("123", "123", "123", "123");
		p.delStudent("123");


	}
}
