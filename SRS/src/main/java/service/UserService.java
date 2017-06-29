package service;

import dao.UserDao;
import model.User;

public class UserService {
	private UserDao userdao=null;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public UserService(UserDao userdao) {
		this.setUserdao(userdao);
		// TODO Auto-generated constructor stub
	}

	/*
	 * 方法
	 */
	public boolean login(User user) {
		User Acctount = userdao.getUser(user.getSsn());	//数据库中数据
		if (Acctount.validate(user)) {
			return true;
		}
		return false;
	}

}
