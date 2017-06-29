package dao;

public class DaoFactory {
	private static String daoName = "daoImpl.sqlite";
	// private static String daoName = "daoImpl.mock";
	// private static String daoName = "daoImpl.mysql";

	public static CourseDao createCourseDao() {
		CourseDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "CourseDao" + "Impl").newInstance();
			result = (CourseDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static ScheduleDao createScheduleDao() {
		ScheduleDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "ScheduleDao" + "Impl").newInstance();
			result = (ScheduleDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static PersonDao createPersonDao() {
		PersonDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "PersonDao" + "Impl").newInstance();
			result = (PersonDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static SectionDao createSectioneDao() {
		SectionDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "SectionDao" + "Impl").newInstance();
			result = (SectionDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static UserDao createUserDao() {
		// TODO Auto-generated method stub
		UserDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "UserDao" + "Impl").newInstance();
			result = (UserDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static StudentDao createStudentDao() {
		// TODO Auto-generated method stub
		StudentDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "StudentDao" + "Impl").newInstance();
			result = (StudentDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static TranscriptDao createTranscriptDao() {
		// TODO Auto-generated method stub
		TranscriptDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "TranscriptDao" + "Impl").newInstance();
			result = (TranscriptDao) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
