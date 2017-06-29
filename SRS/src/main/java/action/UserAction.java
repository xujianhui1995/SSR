package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import model.User;
import service.UserService;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ssn;
	String password;
	String role;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String login() {
		UserService us = new UserService(DaoFactory.createUserDao());
		User user = new User(getSsn(), getPassword());
		if (role.equals("student")) {
			if (us.login(user)) {
				ActionContext.getContext().put("user", user);
				return "student";
			}
		}
		if (role.equals("professor")) {
			if (us.login(user)) {
				return "professor";
			}
		}
		if (role.equals("dean")) {
			if (us.login(user)) {
				return "dean";
			}
		}
		return "redo";
	}

}
