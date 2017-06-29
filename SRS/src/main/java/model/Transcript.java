package model;

import java.util.ArrayList;

public class Transcript {

	private ArrayList<TranscriptEntry> transcriptEntries; 
	//private Student studentOwner;

	/*
	 * 构造器
	 */

	public Transcript(Student s) {
		//setStudentOwner(s);
		transcriptEntries = new ArrayList<TranscriptEntry>();
	}

	/**********************************/

//	public void setStudentOwner(Student s) {
//		studentOwner = s;
//	}
//
//	public Student getStudentOwner() {
//		return studentOwner;
//	}
	
	public ArrayList<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}

	public void setTranscriptEntries(ArrayList<TranscriptEntry> transcriptEntries) {
		this.transcriptEntries = transcriptEntries;
	}

	/********************************/

	public boolean verifyCompletion(Course c) {
		boolean outcome = false;
		for (TranscriptEntry te : transcriptEntries) {
			Section s = te.getSection();
			if (s.isSectionOf(c)) {
			    if (TranscriptEntry.passingGrade(te.getGrade())) {
				outcome = true;
				break;
			    }
			}
		}
		return outcome;
	}

	public void addTranscriptEntry(TranscriptEntry te) {
		transcriptEntries.add(te);
	}

//	public void display() {
//		System.out.println("Transcript for:  " +
//				   getStudentOwner().toString());
//
//		if (transcriptEntries.size() == 0) {
//			System.out.println("\t(no entries)");
//		}
//		else for (TranscriptEntry te : transcriptEntries) {
//			Section sec = te.getSection();
//
//			Course c = sec.getRepresentedCourse();
//
//			ScheduleOfClasses soc = sec.getOfferedIn();
//
//			System.out.println("\tSemester:        " +
//					   soc.getSemester());
//			System.out.println("\tCourse No.:      " +
//					   c.getCourseNo());
//			System.out.println("\tCredits:         " +
//					   c.getCredits());
//			System.out.println("\tGrade Received:  " +
//					   te.getGrade());
//			System.out.println("\t-----");
//		}
//	}
}
