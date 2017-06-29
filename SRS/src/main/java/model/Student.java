package model;

import java.util.ArrayList;

public class Student extends Person {

	private String major;
	private String degree;
	private Transcript transcript;
	private ArrayList<Section> attends;//选修的课程

	/*
	 * 构造器
	 */

	public Student(String name, String ssn, String major, String degree) {
		super(name, ssn);
		this.setMajor(major);
		this.setDegree(degree);
		this.setTranscript(new Transcript(this));
		attends = new ArrayList<Section>();
	}

	public Student(String ssn) {
		this("TBD", ssn, "TBD", "TBD");
	}

	public void setMajor(String major) {
		this.major = major;
	}	
	/*************************/
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public ArrayList<Section> getAttends() {
		return attends;
	}

	public void setAttends(ArrayList<Section> attends) {
		this.attends = attends;
	}

	public String getMajor() {
		return major;
	}
	/*************************/

	@Override
	public void display() {
		super.display();

		System.out.println("Student-Specific Information:");
		System.out.println("\tMajor:  " + this.getMajor());
		System.out.println("\tDegree:  " + this.getDegree());
		this.displayCourseSchedule();
		//this.printTranscript();

		System.out.println();
	}

	@Override
	public String toString() {
		return this.getName() + " (" + this.getSsn() + ") [" + this.getDegree() + " - " + this.getMajor() + "]";
	}

	public void displayCourseSchedule() {

		System.out.println(this.getName()+"的课程表");

		for (Section s : attends) {
			if (s.getGrade(this) == null) {
				System.out.println("\tCourse No.:  " + s.getRepresentedCourse().getCourseNo());
				System.out.println("\tSection No.:  " + s.getSectionNo());
				System.out.println("\tCourse Name:  " + s.getRepresentedCourse().getCourseName());
				System.out.println("\tMeeting Day and Time Held:  " + s.getDayOfWeek() + " - " + s.getTimeOfDay());
				System.out.println("\tRoom Location:  " + s.getRoom());
				System.out.println("\tProfessor's Name:  " + s.getInstructor().getName());
				System.out.println("\t-----");
			}
		}
	}
	//添加课程
	public void addSection(Section s) {
		attends.add(s);
	}
	//删除课程
	public void dropSection(Section s) {
		attends.remove(s);
	}
	//是否参加了该课程
	public boolean isEnrolledIn(Section s) {
		if (attends.contains(s))
			return true;
		else
			return false;
	}

	public boolean isCurrentlyEnrolledInSimilar(Section s1) {
		boolean foundMatch = false;
		Course c1 = s1.getRepresentedCourse();
		for (Section s2 : attends) {
			Course c2 = s2.getRepresentedCourse();
			if (c1 == c2) {
				if (s2.getGrade(this) == null) {
					foundMatch = true;
					break;
				}
			}
		}
		return foundMatch;
	}

	public PlanOfStudy getPlan() {
		PlanOfStudy PlanOfStudy = null;
		// TODO Auto-generated method stub
		return PlanOfStudy;
	}

//	public void printTranscript() {
//		this.getTranscript().display();
//	}

	
}
