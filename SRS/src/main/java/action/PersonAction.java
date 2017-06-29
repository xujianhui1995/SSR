package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import model.Professor;
import service.PersonService;

public class PersonAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String result;

	PersonService ps = new PersonService(DaoFactory.createPersonDao());

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
	public String addProfessor() {
		Professor prodessor = new Professor(request.getParameter("name"), request.getParameter("ssn"), request.getParameter("title"), request.getParameter("department"));
		ps.addProfessor(prodessor);
		return "professor";
	}

	public String delProfessor() {
		ps.delProfessor(request.getParameter("ssn"));
		return "professor";
	}

	public String findAllProfessors() {
		Gson gson=new Gson();
		result=gson.toJson(ps.findAllProfessors().values());
//		System.out.println(result);
		return SUCCESS;
	}
}
