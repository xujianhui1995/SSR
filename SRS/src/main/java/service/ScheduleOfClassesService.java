package service;

import dao.ScheduleDao;
import model.ScheduleOfClasses;

public class ScheduleOfClassesService {
	
	private ScheduleDao scheduleDao;
    
    public ScheduleOfClassesService(ScheduleDao scheduleDao) {
		this.setScheduleDao(scheduleDao) ;
	}

	public ScheduleOfClasses getScheduleOfClasses(String semester) {
		return scheduleDao.getScheduleOfClass(semester);

	}    

	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	
    

}
