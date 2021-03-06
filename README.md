# SSR

系统分层结构图


![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E7%B3%BB%E7%BB%9F%E5%88%86%E5%B1%82%E7%BB%93%E6%9E%84%E5%9B%BE.PNG)

系统领域类图


![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E7%B1%BB%E5%9B%BE.PNG)

顺序图


![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E6%97%B6%E5%BA%8F%E5%9B%BE1.png)

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E6%97%B6%E5%BA%8F%E5%9B%BE2.png)


数据库结构

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E6%95%B0%E6%8D%AE%E5%BA%93.PNG)

选课逻辑实现
------------

PlanOfStudy类

	private Student student;
	private List<Course> courselist;

Section类
	
	public boolean inPlan(Student s) {
		for (Course course : s.getPlan().getCourselist()) {
			if (this.getRepresentedCourse().getCourseNo().equals(course.getCourseNo())) {
				return true;
			}
		}
		return false;
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


系统运行结果主要界面截图


学生登录
---------

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E5%AD%A6%E7%94%9F%E7%99%BB%E5%BD%95.PNG)

学生选课
------------

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E5%AD%A6%E7%94%9F%E9%80%89%E8%AF%BE.PNG)


教师增删改
-----------

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E6%95%99%E5%B8%88%E5%A2%9E%E5%88%A0%E6%94%B9.PNG)

课程增删改
------------

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E8%AF%BE%E7%A8%8B%E7%9A%84%E5%A2%9E%E5%88%A0%E6%94%B9.PNG)

选课情况和成绩查询
----------------

![](https://github.com/xujianhui1995/SSR/blob/master/%E6%88%AA%E5%9B%BE/%E9%80%89%E8%AF%BE%E6%83%85%E5%86%B5%E5%92%8C%E6%88%90%E7%BB%A9.PNG)
