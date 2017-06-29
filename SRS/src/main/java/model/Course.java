package model;

import java.util.ArrayList;

public class Course {
	/*
	 * 课程属性
	 */
	private String courseNo;
	private String courseName;
	private double credits;
	private ArrayList<Section> offeredAsSection;
	private ArrayList<Course> prerequisites;

	/*************************/

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public ArrayList<Section> getOfferedAsSection() {
		return offeredAsSection;
	}

	public void setOfferedAsSection(ArrayList<Section> offeredAsSection) {
		this.offeredAsSection = offeredAsSection;
	}

	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	/*************************/

	/*
	 * 构造器
	 */
	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);
		offeredAsSection = new ArrayList<Section>();
		prerequisites = new ArrayList<Course>();
	}

	public void display() {
		System.out.println("Course Information:");
		System.out.println("\tCourse No.:  " + getCourseNo());
		System.out.println("\tCourse Name:  " + getCourseName());
		System.out.println("\tCredits:  " + getCredits());
		System.out.println("\tPrerequisite Courses:");

		for (Course c : prerequisites) {
			System.out.println("\t\t" + c.toString());
		}

		System.out.print("\tOffered As Section(s):  ");
		for (Section s : offeredAsSection) {
			System.out.print(s.getSectionNo() + " ");
		}

		System.out.println();
	}

	@Override
	public String toString() {
		return getCourseNo() + ":  " + getCourseName();
	}

	// 添加先修课程
	public void addPrerequisite(Course c) {
		prerequisites.add(c);
	}

	// 是否有先修课程
	public boolean hasPrerequisites() {
		if (prerequisites.size() > 0)
			return true;
		else
			return false;
	}

	public Section scheduleSection(Section s) {
//		Section s = new Section(offeredAsSection.size() + 1, day, time, this, room, capacity);
		addSection(s);
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}
}
