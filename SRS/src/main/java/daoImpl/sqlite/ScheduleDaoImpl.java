package daoImpl.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ScheduleDao;
import daoImpl.mock.CourseDaoImpl;
import model.Course;
import model.EnrollmentStatus;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;
import util.DBUtil;

public class ScheduleDaoImpl implements ScheduleDao {
	Course c;
	ScheduleOfClasses scheduleOfClasses;

	Map<String, Course> allCourses;
	HashMap<String, Section> sections = new HashMap<String, Section>();
	List<Section> sectionlist = new ArrayList<Section>();
	List<ScheduleOfClasses> schedule = new ArrayList<ScheduleOfClasses>();
	private PreparedStatement pstmt;

	public ScheduleDaoImpl() {
		CourseDaoImpl courseimpl = new CourseDaoImpl();
		allCourses = courseimpl.findAllMap();

	}

	@Override
	public List<ScheduleOfClasses> getScheduleOfClass() {
		// TODO Auto-generated method stub
		String sql = "select * from section;";
		try {
			pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sNo = Integer.parseInt(rs.getString("sectionNo"));
				char dayOfWeek = rs.getString("dayOfWeek").charAt(0);
				String timeOfDay = rs.getString("timeOfDay");
				String room = rs.getString("room");
				int seatingCapacity = Integer.parseInt(rs.getString("seatingCapacity"));
				String semester = rs.getString("semester");
				String representedCourse = rs.getString("representedCourse");
				c = allCourses.get(representedCourse);
				Section sec = new Section(sNo, dayOfWeek, timeOfDay, c, room, seatingCapacity);
				scheduleOfClasses = new ScheduleOfClasses(semester);
				scheduleOfClasses.addSection(sec);
				schedule.add(scheduleOfClasses);
			}
			pstmt.close();
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedule;
	}

	@Override
	public List<ScheduleOfClasses> getScheduleOfClassBySemester(String semester) {
		// TODO Auto-generated method stub
		String sql = "select * from section where semester=?;";
		try {
			pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			pstmt.setString(1, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sNo = Integer.parseInt(rs.getString("sectionNo"));
				char dayOfWeek = rs.getString("dayOfWeek").charAt(0);
				String timeOfDay = rs.getString("timeOfDay");
				String room = rs.getString("room");
				int seatingCapacity = Integer.parseInt(rs.getString("seatingCapacity"));
				String representedCourse = rs.getString("representedCourse");
				c = allCourses.get(representedCourse);
				Section sec = new Section(sNo, dayOfWeek, timeOfDay, c, room, seatingCapacity);
				scheduleOfClasses = new ScheduleOfClasses(semester);
				scheduleOfClasses.addSection(sec);
				schedule.add(scheduleOfClasses);
			}
			pstmt.close();
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedule;
	}

	@Override
	public EnrollmentStatus enroll(Section section, Student student) {
		// TODO Auto-generated method stub
		if (section.enroll(student).equals(EnrollmentStatus.success)) {
			String sql = "insert into transcript(studentSsn,sectionNo) values(?,?);";
			try {
				PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
				pstmt.setString(1, student.getSsn());
				pstmt.setString(2, section.getFullSectionNo());
				pstmt.execute();
				sql = "UPDATE section SET seatingCapacity=seatingCapacity-1 where sectionNo=?;";
				pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
				pstmt.setString(1, section.getFullSectionNo().substring(9, 10));
				pstmt.execute();
				pstmt.close();
				DBUtil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return section.enroll(student);
	}

	@Override
	public Section getSectionBySectionNo(String FullNo) {
		// TODO Auto-generated method stub
		String sql = "select * from section where representedCourse=? and SectionNo=?;";
		Section section = null;
		try {
			pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			pstmt.setString(1, FullNo.substring(0, 6));
			pstmt.setString(2, FullNo.substring(9, 10));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				c = allCourses.get(rs.getString("representedCourse"));
				section = new Section(Integer.parseInt(rs.getString("sectionNo")), rs.getString("dayOfWeek").charAt(0),
						rs.getString("timeOfDay"), c, rs.getString("room"),
						Integer.parseInt(rs.getString("seatingCapacity")));
				section.setOfferedIn(new ScheduleOfClasses(rs.getString("semester")));
			}
			pstmt.close();
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return section;
	}

	@Override
	public List<ScheduleOfClasses> findAllByStudent(String studentSsn) {
		// TODO Auto-generated method stub
		String sql = "select * from transcript where studentSsn=?;";
		try {
			pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			pstmt.setString(1, studentSsn);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String sectionNo = rs.getString("sectionNo");
				sql = "select * from section where representedCourse=? and sectionNo=?";
				pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
				pstmt.setString(1, sectionNo.substring(0, 6));
				pstmt.setString(2, sectionNo.substring(9, 10));
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {
					int sNo = Integer.parseInt(rs2.getString("sectionNo"));
					char dayOfWeek = rs2.getString("dayOfWeek").charAt(0);
					String timeOfDay = rs2.getString("timeOfDay");
					String room = rs2.getString("room");
					int seatingCapacity = Integer.parseInt(rs2.getString("seatingCapacity"));
					String representedCourse = rs2.getString("representedCourse");
					String semester = rs2.getString("semester");
					c = allCourses.get(representedCourse);
					Section sec = new Section(sNo, dayOfWeek, timeOfDay, c, room, seatingCapacity);
					scheduleOfClasses = new ScheduleOfClasses(semester);
					scheduleOfClasses.addSection(sec);
					schedule.add(scheduleOfClasses);
				}
			}
			pstmt.close();
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedule;
	}
}
