package service;

import java.util.HashMap;

import dao.PersonDao;
import model.Professor;

public class PersonService {
	private PersonDao persondao;

	public PersonDao getPersondao() {
		return persondao;
	}

	public void setPersondao(PersonDao persondao) {
		this.persondao = persondao;
	}

	public PersonService(PersonDao persondao) {
		this.setPersondao(persondao);
	}
	/*
	 * 方法
	 */
	public boolean addProfessor(Professor prodessor){
		return persondao.addProfessor(prodessor.getSsn(), prodessor.getName(), prodessor.getTitle(), prodessor.getDepartment());
		
	}
	public boolean delProfessor(String ssn){
		return persondao.delProfessor(ssn);
		
	}
	public HashMap<String, Professor> findAllProfessors() {
		return persondao.findAllProfessors();
	}		

}
