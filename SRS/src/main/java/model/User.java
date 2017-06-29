package model;

public class User {
	private String ssn;
	private String password;
	private String role; 
	
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
	
	public User(String ssn, String password) {
		this.setSsn(ssn);
		this.setPassword(password);
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public boolean validate(User user) {
		// TODO Auto-generated method stub
		if(this.ssn.equals(user.getSsn())&&this.password.equals(user.getPassword()))
		return true;
		else return false;
	}
	
}
