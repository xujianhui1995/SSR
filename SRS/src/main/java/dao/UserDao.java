package dao;

import model.User;

public interface UserDao {
	public User getUser(String ssn);
}
