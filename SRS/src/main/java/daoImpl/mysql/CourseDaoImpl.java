package daoImpl.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.CourseDao;
import model.Course;
import model.CourseCatalog;
import util.DBUtil;

public class CourseDaoImpl implements CourseDao {
	private PreparedStatement pstmt;
	HashMap<String, Course> courses = new HashMap<String, Course>();
	CourseCatalog coursecatlog = new CourseCatalog();

	public CourseDaoImpl() {
		// TODO Auto-generated constructor stub
		String sql = "select * from course;";
		try {
			pstmt = DBUtil.getSqliteConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String courseNo = rs.getString("courseNo");
				String courseName = rs.getString("courseName");
				double credits = rs.getDouble("credits");
				Course course = new Course(courseNo, courseName, credits);
				// 查询先修课
				sql = "select * from prerequisites,course where course.courseNo=prerequisites.courseNo;";
				pstmt = DBUtil.getSqliteConnection().prepareStatement(sql);
				ResultSet rsprerequisites = pstmt.executeQuery();
				while (rsprerequisites.next()) {
					String courseNo2 = rsprerequisites.getString("courseNo");
					String courseName2 = rsprerequisites.getString("courseName");
					double credits2 = rsprerequisites.getDouble("credits");
					Course prerequisitescourse = new Course(courseNo2, courseName2, credits2);
					if (courseNo.equals(courseNo2))
						course.addPrerequisite(prerequisitescourse);
					courses.put(courseNo, course);
				}
			}
			coursecatlog.setCourses(courses);
			pstmt.close();
			DBUtil.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HashMap<String, Course> findAllMap() {
		return courses;
	}

	@Override
	public CourseCatalog findAll() {

		return coursecatlog;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		coursecatlog.addCourse(course);
		String sql = "insert into course values(?,?,?);";
		try {
			pstmt = DBUtil.getSqliteConnection().prepareStatement(sql);
			pstmt.setString(1, course.getCourseNo());
			pstmt.setString(2, course.getCourseName());
			pstmt.setDouble(3, course.getCredits());

			pstmt.executeUpdate();
			// coursecatlog.setCourses(courses);
			ArrayList<Course> prerequisitescourse =course.getPrerequisites();
			for(Course tmp:prerequisitescourse){
				sql = "insert into prerequisites(courseNo,prerequisites) values(?,?);";
				pstmt = DBUtil.getSqliteConnection().prepareStatement(sql);
				pstmt.setString(1, course.getCourseNo());
				pstmt.setString(2, tmp.getCourseNo());
				pstmt.executeUpdate();				
			}
			pstmt.close();
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delCourse(Course course) {
		// TODO Auto-generated method stub
		coursecatlog.delCourse(course);
		String sql = "DELETE FROM course where courseNo=?;";
		try {
			pstmt = DBUtil.getSqliteConnection().prepareStatement(sql);
			pstmt.setString(1, course.getCourseNo());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
