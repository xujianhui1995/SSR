package service;

import java.util.List;

import dao.ScheduleDao;
import model.ScheduleOfClasses;

public class ScheduleOfClassesService {
	
	private ScheduleDao scheduleDao;
    /*
     * 构造器
     */
    public ScheduleOfClassesService(ScheduleDao scheduleDao) {
		this.setScheduleDao(scheduleDao) ;
	}   
    /*********************************/
	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	/***********************************/
	/*
	 * 方法
	 */
	public List<ScheduleOfClasses> getScheduleOfClassesBySemester(String semester) {
		return scheduleDao.getScheduleOfClassBySemester(semester);

	}

	public List<ScheduleOfClasses> findAll() {
		// TODO Auto-generated method stub
		return scheduleDao.getScheduleOfClass();
	}

	public List<ScheduleOfClasses> findBySemester(String semester) {
		// TODO Auto-generated method stub
		return scheduleDao.getScheduleOfClassBySemester(semester);
	} 
	
    

}
