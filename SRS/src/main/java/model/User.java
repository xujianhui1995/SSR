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
	
	public User(String ssn, String password, String role) {
		this.setSsn(ssn);
		this.setPassword(password);
		this.setRole(role);
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public boolean login(String ssn, String password) {
		// TODO Auto-generated method stub
		if(this.ssn.equals(ssn)&&this.password.equals(password))
		return true;
		else return false;
	}
	
}
