package serviceTest;

import org.junit.Test;

import dao.DaoFactory;
import daoImpl.mock.UserDaoImpl;
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
		User u=new User("lee", "123", "student");
		UserService us=new UserService(DaoFactory.createUserDao());
		boolean islogin=us.login(u);
		System.out.println(islogin);
	}
}
