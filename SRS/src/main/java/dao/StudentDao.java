package dao;

import java.util.ArrayList;

import model.Student;

public interface StudentDao {
	public ArrayList<Student> findAll();

	public Student findBySsn(String studentSsn);

}
