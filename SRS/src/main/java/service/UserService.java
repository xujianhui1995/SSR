package service;

import dao.DaoFactory;
import daoImpl.mock.UserDaoImpl;
import model.User;

public class UserService {
	private UserDaoImpl userdao;

	public UserDaoImpl getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDaoImpl userdao) {
		this.userdao = userdao;
	}
	
	public UserService(UserDaoImpl userdao) {
		this.setUserdao(userdao);
	}

	public boolean login(User user) {

		UserDaoImpl userDao = DaoFactory.createUserDao();		

		if (user.getSsn() != null && user.getPassword() != null) {
			User Acctount = userDao.getUser();
			if (Acctount != null && Acctount.getPassword().equals(user.getPassword())) {
				return true;
			}
			return false;
		}
		return false;
	}
}
