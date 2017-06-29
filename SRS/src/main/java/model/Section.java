package model;

import java.util.HashMap;

public class Section {

	private int sectionNo;
	private char dayOfWeek;
	private String timeOfDay;
	private String room;
	private int seatingCapacity;
	private Course representedCourse;//
	private ScheduleOfClasses offeredIn;//
	private Professor instructor;// 讲授

	private HashMap<String, Student> enrolledStudents;
	private HashMap<Student, TranscriptEntry> assignedGrades;

	/*
	 * 构造器
	 */
	public Section(int sNo, char day, String time, Course course, String room, int capacity) {
		setSectionNo(sNo);
		setDayOfWeek(day);
		setTimeOfDay(time);
		setRepresentedCourse(course);
		setRoom(room);
		setSeatingCapacity(capacity);
		setInstructor(null);

		enrolledStudents = new HashMap<String, Student>();
		assignedGrades = new HashMap<Student, TranscriptEntry>();
	}

	/*************************/

	public void setSectionNo(int no) {
		sectionNo = no;
	}

	public int getSectionNo() {
		return sectionNo;
	}

	public void setDayOfWeek(char day) {
		dayOfWeek = day;
	}

	public char getDayOfWeek() {
		return dayOfWeek;
	}

	public void setTimeOfDay(String time) {
		timeOfDay = time;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setInstructor(Professor prof) {
		instructor = prof;
	}

	public Professor getInstructor() {
		return instructor;
	}

	public void setRepresentedCourse(Course c) {
		representedCourse = c;
	}

	public Course getRepresentedCourse() {
		return representedCourse;
	}

	public void setRoom(String r) {
		room = r;
	}

	public String getRoom() {
		return room;
	}

	public void setSeatingCapacity(int c) {
		seatingCapacity = c;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setOfferedIn(ScheduleOfClasses soc) {
		offeredIn = soc;
	}

	public ScheduleOfClasses getOfferedIn() {
		return offeredIn;
	}

	public HashMap<String, Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(HashMap<String, Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public HashMap<Student, TranscriptEntry> getAssignedGrades() {
		return assignedGrades;
	}

	public void setAssignedGrades(HashMap<Student, TranscriptEntry> assignedGrades) {
		this.assignedGrades = assignedGrades;
	}

	/***********************/

	@Override
	public String toString() {
		return getRepresentedCourse().getCourseNo() + "-" + getSectionNo() + " - " + getDayOfWeek() + " - "
				+ getTimeOfDay();
	}

	public String getFullSectionNo() {
		return getRepresentedCourse().getCourseNo() + " - " + getSectionNo();
	}

	public String getFullSectionInfo() {
		return getRepresentedCourse().getCourseName() + "-" + getDayOfWeek() + "-" + "" + getTimeOfDay() + "-"
				+ this.getRoom();
	}

	public EnrollmentStatus enroll(Student s) {
		Transcript transcript = s.getTranscript();
		if (s.isCurrentlyEnrolledInSimilar(this) || transcript.verifyCompletion(this.getRepresentedCourse())) {
			return EnrollmentStatus.prevEnroll;
		}

		Course c = this.getRepresentedCourse();
		if (c.hasPrerequisites()) {
			for (Course pre : c.getPrerequisites()) {
				if (!transcript.verifyCompletion(pre)) {
					return EnrollmentStatus.prereq;
				}
			}
		}

		if (!this.confirmSeatAvailability()&&!this.inPlan(s)) {
			return EnrollmentStatus.secFull;
		}

		enrolledStudents.put(s.getSsn(), s);
		s.addSection(this);

		return EnrollmentStatus.success;
	}

	private boolean confirmSeatAvailability() {
		if (enrolledStudents.size() < getSeatingCapacity())
			return true;
		else
			return false;
	}

	public boolean drop(Student s) {
		if (!s.isEnrolledIn(this))
			return false;
		else {
			enrolledStudents.remove(s.getSsn());
			s.dropSection(this);
			return true;
		}
	}

	public boolean inPlan(Student s) {
		for (Course course : s.getPlan().getCourselist()) {
			if (this.getRepresentedCourse().getCourseNo().equals(course.getCourseNo())) {
				return true;
			}
		}
		return false;
	}

	public int getTotalEnrollment() {
		return enrolledStudents.size();
	}

	public void display() {
		System.out.println("Section Information:");
		System.out.println("\tSemester:  " + getOfferedIn().getSemester());
		System.out.println("\tCourse No.:  " + getRepresentedCourse().getCourseNo());
		System.out.println("\tSection No:  " + getSectionNo());
		System.out.println("\tOffered:  " + getDayOfWeek() + " at " + getTimeOfDay());
		System.out.println("\tIn Room:  " + getRoom());
		if (getInstructor() != null)
			System.out.println("\tProfessor:  " + getInstructor().getName());
		displayStudentRoster();
	}

	public void displayStudentRoster() {
		System.out.print("\tTotal of " + getTotalEnrollment() + " students enrolled");

		if (getTotalEnrollment() == 0)
			System.out.println(".");
		else
			System.out.println(", as follows:");

		for (Student s : enrolledStudents.values()) {
			System.out.println("\t\t" + s.getName());
		}
	}

	public String getGrade(Student s) {
		String grade = null;
		TranscriptEntry te = assignedGrades.get(s);
		if (te != null) {
			grade = te.getGrade();
		}
		return grade;
	}

	public boolean postGrade(Student s, String grade) {
		if (!TranscriptEntry.validateGrade(grade))
			return false;
		if (assignedGrades.get(s) != null)
			return false;
		TranscriptEntry te = new TranscriptEntry(s, grade, this);
		assignedGrades.put(s, te);
		return true;
	}

	public boolean isSectionOf(Course c) {
		if (c == representedCourse)
			return true;
		else
			return false;
	}
}
