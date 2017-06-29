package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import model.Student;
import model.TranscriptEntry;
import service.TranscriptService;

public class TranscriptAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private TranscriptService transcriptservice = new TranscriptService(DaoFactory.createTranscriptDao());
	private HttpServletRequest request;
	private String result;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 
	 * @方法
	 */
	public String getTranscript() {
		List<TranscriptEntry> list=transcriptservice.getTranscript().getTranscriptEntries();
		Gson gson=new Gson();
		result=gson.toJson(list);
		return SUCCESS;
	}

	public String getTranscriptByStudent(Student student) {
		transcriptservice.getTranscriptByStudent(student);
		return SUCCESS;
	}

	public String postTranscript(Student studnet) {
		transcriptservice.postTranscript(studnet);
		return SUCCESS;
	}
}
