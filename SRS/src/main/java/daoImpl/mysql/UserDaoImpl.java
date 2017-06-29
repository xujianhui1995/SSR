package daoImpl.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import model.User;
import util.DBUtil;

public class UserDaoImpl implements UserDao{
	public User getUser(String ssn){
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select * from user where ssn=?;";
		try {
			PreparedStatement pstmt = DBUtil.getSqliteConnection().prepareStatement(sql);
			pstmt.setString(1, ssn);
			ResultSet rsprerequisites = pstmt.executeQuery();
			while (rsprerequisites.next()) {
				String password = rsprerequisites.getString("password");
				if(password!=null)
				user=new User(ssn, password);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
