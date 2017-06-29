package util;

import java.sql.*;

public class DBUtil {

	static Connection conn = null;
	static PreparedStatement pst = null;

	public static Connection getSqliteConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:guitar.db");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static Connection getMysqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 指定连接类型
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "123456");// 获取连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getSQLServerConnection() {
		try {
			String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=guitar;";
			Class.forName(DriverName);
			conn = DriverManager.getConnection(url, "sa", "12345");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
