package service;

import java.util.ArrayList;

import dao.TranscriptDao;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;

public class TranscriptService {
	private TranscriptDao tanscriptdao;

	public TranscriptDao getTanscriptdao() {
		return tanscriptdao;
	}

	public void setTanscriptdao(TranscriptDao tanscriptdao) {
		this.tanscriptdao = tanscriptdao;
	}

	public TranscriptService(TranscriptDao tanscriptdao) {
		// TODO Auto-generated constructor stub
		this.setTanscriptdao(tanscriptdao);
	}

	public Transcript getTranscript() {
		// TODO Auto-generated method stub
		return tanscriptdao.getTranscript();
	}

	public void getTranscriptByStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void postTranscript(Student studnet) {
		// TODO Auto-generated method stub
		
	}
	
}
