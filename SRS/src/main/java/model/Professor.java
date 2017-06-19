package model;


import java.util.ArrayList;

public class Professor extends Person {

	private String title;
	private String department;
	private ArrayList<Section> teaches; 

	/*
	 * 构造器
	 */
	public Professor(String name, String ssn, String title, String dept) {
		super(name, ssn);
		setTitle(title);
		setDepartment(dept);
		teaches = new ArrayList<Section>();
	}
	/*************************/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public ArrayList<Section> getTeaches() {
		return teaches;
	}

	public void setTeaches(ArrayList<Section> teaches) {
		this.teaches = teaches;
	}
	/*************************/
	
	

	@Override
	public void display() {
		super.display();
		
		System.out.println("Professor-Specific Information:");
		System.out.println("\tTitle:  " + getTitle());
		System.out.println("\tTeaches for Dept.:  " + getDepartment());
		displayTeachingAssignments();

		System.out.println();
	}

	@Override
	public String toString() {
		return getName() + " (" + getTitle() + ", " +
		       getDepartment() + ")";
	}
	
	public void displayTeachingAssignments() {
		System.out.println(getName() + "的教学任务： ");

		if (teaches.size() == 0) {
			System.out.println("\t(none)");
		}

		else for (Section s : teaches) {

			System.out.println("\tCourse No.:  " +
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\tSection No.:  " + 
				s.getSectionNo());
			System.out.println("\tCourse Name:  " +
				s.getRepresentedCourse().getCourseName());
			System.out.println("\tDay and Time:  " +
				s.getDayOfWeek() + " - " + 
				s.getTimeOfDay());
			System.out.println("\t-----");
		}
	}
	//负责该课程的教学
	public void agreeToTeach(Section s) {
		teaches.add(s);
		s.setInstructor(this);
	}
}
