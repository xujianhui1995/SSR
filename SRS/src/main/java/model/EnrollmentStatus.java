package model;

public enum EnrollmentStatus {

	success("选课成功  :o)"),
	secFull("选课失败;  选课人数已满 :op"),
	prereq("选课失败; 请先完成先修课程  :op"), 
	prevEnroll("选课失败; 请勿重复选修 :op");

	private final String value;

	EnrollmentStatus(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
