package edu.mum.cs544;

import edu.mum.cs544.util.EntityManagerHelper;

import javax.persistence.EntityManager;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		EntityManager entityManager = EntityManagerHelper.getCurrent();
		entityManager.getTransaction().begin();
		Student student = studentdao.load(studentid);

		entityManager.getTransaction().commit();
		entityManager.close();

		return student;
	}
}
