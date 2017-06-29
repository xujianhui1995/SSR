package daoImpl.mock;

import java.util.ArrayList;
import java.util.HashMap;

import dao.TranscriptDao;
import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;

public class TranscriptImpl implements TranscriptDao{
	
	HashMap<Student, TranscriptEntry> TranscriptEntries=new HashMap<Student,TranscriptEntry>();
	ArrayList<TranscriptEntry> transcriptEntries=new ArrayList<TranscriptEntry>();
	
	Student student = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");
	Section se1=(new SectionDaoImpl()).findAll().get(0);
	Section se2=(new SectionDaoImpl()).findAll().get(1);


	public ArrayList<TranscriptEntry> findAll(){
		// TODO Auto-generated method stub	
		se1.postGrade(student, "A+");
		se2.postGrade(student, "A+");
		return student.getTranscript().getTranscriptEntries();
	}
	@Override
	public HashMap<String, TranscriptEntry> findAllTranscriptEntriesBySection() {
		// TODO Auto-generated method stub
		se1.postGrade(student, "A+");
		se1.postGrade(student, "A+");
		return null;
	}
	@Override
	public HashMap<String, TranscriptEntry> findAllTranscriptEntriesByStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Transcript getTranscript() {
		// TODO Auto-generated method stub
		return null;
	}

}
