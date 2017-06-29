package daoImpl.mock;

import model.User;

public class UserDaoImpl {
	public User getUser(){
		// TODO Auto-generated method stub
		User user=new User("lee", "123");
		return user;
	}
}
