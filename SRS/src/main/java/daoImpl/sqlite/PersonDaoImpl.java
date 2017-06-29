package daoImpl.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import dao.PersonDao;
import model.Professor;
import model.Student;
import util.DBUtil;

public class PersonDaoImpl implements PersonDao {
	
	public boolean addProfessor(String ssn,String name,String title,String department){
		String sql = "insert into professor(ssn,name,title,department) values(?,?,?,?);";
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);	
			pstmt.setString(1, ssn);
			pstmt.setString(2, name);
			pstmt.setString(3, title);
			pstmt.setString(4, department);
			pstmt.execute();			
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;		
	}
	public boolean delProfessor(String ssn){
		String sql = "delete from professor where ssn=?;";
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);	
			pstmt.setString(1, ssn);
			pstmt.execute();			
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;		
	}
	
	@Override
	public HashMap<String, Professor> findAllProfessors() {		
		HashMap<String, Professor> professors = new HashMap<String, Professor>();	
		String sql = "select * from professor;";
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String ssn = rs.getString("ssn");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String department = rs.getString("department");
				Professor professor=new Professor(name, ssn, title, department);				
				professors.put(ssn, professor);
			}
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return professors;
	}

	@Override
	public HashMap<String, Student> findAllStudents() {
		HashMap<String, Student> Students = new HashMap<String, Student>();			
		String sql = "select * from professor;";
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
//				String ssn = rs.getString("ssn");
//				String name = rs.getString("name");
//				String title = rs.getString("title");
//				String department = rs.getString("department");
//				Professor professor=new Professor(name, ssn, title, department);				
//				professors.put(ssn, professor);
			}
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Students;
	}
	
	public boolean addStudent(String ssn,String name,String major,String degree){
		String sql = "insert into student(ssn,name,major,degree) values(?,?,?,?);";
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);	
			pstmt.setString(1, ssn);
			pstmt.setString(2, name);
			pstmt.setString(3, major);
			pstmt.setString(4, degree);
			pstmt.execute();			
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;		
	}
	public boolean delStudent(String ssn){
		String sql = "delete from student where ssn=?;";
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);	
			pstmt.setString(1, ssn);
			pstmt.execute();			
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;		
	}
}
