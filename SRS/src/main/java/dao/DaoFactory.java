package dao;

import daoImpl.mock.UserDaoImpl;

public class DaoFactory {
	// private static String daoName = "daoImpl.sqlite";
	private static String daoName = "daoImpl.mock";

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

	public static UserDaoImpl createUserDao() {
		// TODO Auto-generated method stub
		UserDaoImpl result = null;
		try {
			Object o = Class.forName(daoName + "." + "UserDao" + "Impl").newInstance();
			result = (UserDaoImpl) o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
