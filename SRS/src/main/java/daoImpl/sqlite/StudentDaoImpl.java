package daoImpl.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.StudentDao;
import model.Student;
import util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public ArrayList<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findBySsn(String studentSsn) {
		// TODO Auto-generated method stub
		String sql = "select * from student where ssn=?;";
		Student student = null;
		try {
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			pstmt.setString(1, studentSsn);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				student=new Student(rs.getString("name"), rs.getString("ssn"), rs.getString("major"), rs.getString("degree"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
