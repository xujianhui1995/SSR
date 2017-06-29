package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;
import service.ScheduleOfClassesService;
import service.SectionService;
import service.StudentService;

public class SectionAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String result;

	ScheduleOfClassesService scheduleOfClassesService = new ScheduleOfClassesService(DaoFactory.createScheduleDao());
	SectionService sectionservice = new SectionService(DaoFactory.createScheduleDao());
	StudentService studentservice = new StudentService(DaoFactory.createStudentDao());

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * 方法
	 */
	public String findAll() {
		try {
			List<ScheduleOfClasses> sections = scheduleOfClassesService.findAll();
			Gson gson = new Gson();
			result = gson.toJson(sections);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";

	}

	public String findAllBySemester() {
		try {
			List<ScheduleOfClasses> sections = new ArrayList<ScheduleOfClasses>();
			String semester = request.getParameter("semester");
			sections = scheduleOfClassesService.findBySemester(semester);
			Gson gson = new Gson();
			result = gson.toJson(sections);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";

	}

	public String enroll() {
		String sectionFullNo = request.getParameter("sectionFullNo");
		String studentSsn = request.getParameter("studentSsn");
		Section section = sectionservice.getSectionBySectionNo(sectionFullNo);
		Student student = studentservice.findBySsn(studentSsn);
		//ActionContext.getContext().put("status", sectionservice.enroll(section, student));
		sectionservice.enroll(section, student);
		return "success";
	}
	
	public String getSectionsByStudent() {
		String studentSsn = request.getParameter("studentSsn");
		Gson gson = new Gson();
		result = gson.toJson(sectionservice.findAllByStudent(studentSsn));
		return "success";
	}
}
