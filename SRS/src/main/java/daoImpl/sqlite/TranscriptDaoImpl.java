package daoImpl.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.TranscriptDao;
import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import util.DBUtil;

public class TranscriptDaoImpl implements TranscriptDao{
	Transcript Transcript=null;
	HashMap<Student, TranscriptEntry> TranscriptEntries=new HashMap<Student,TranscriptEntry>();
	ArrayList<TranscriptEntry> list=new ArrayList<TranscriptEntry>();
	
	@Override
	public Transcript getTranscript() {
		try {
			String sql = "select * from transcript;";
			PreparedStatement pstmt = DBUtil.getMysqlConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String studentSsn = rs.getString("studentSsn");
				String sectionNo = rs.getString("sectionNo");
				String grade = rs.getString("grade");
				Student student = (new StudentDaoImpl()).findBySsn(studentSsn);
				ScheduleDaoImpl schedule=new ScheduleDaoImpl();
				Section section =schedule.getSectionBySectionNo(sectionNo);
				TranscriptEntry e=new TranscriptEntry(student, grade, section);
				list.add(e);
				Transcript=new Transcript(student);
				Transcript.setTranscriptEntries(list);
			}
			pstmt.close();
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Transcript;
	}

	@Override
	public HashMap<String, TranscriptEntry> findAllTranscriptEntriesBySection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, TranscriptEntry> findAllTranscriptEntriesByStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
