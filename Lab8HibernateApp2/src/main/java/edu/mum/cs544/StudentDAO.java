package edu.mum.cs544;

import edu.mum.cs544.util.EntityManagerHelper;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {

//	private Collection<Student> studentlist = new ArrayList<Student>();

//	public StudentDAO() {
//		Student student = new Student(12345, "Frank", "Brown");
//		Course course1 = new Course(1101, "Java", "A");
//		Course course2 = new Course(1102, "Math", "B-");
//		student.addCourse(course1);
//		student.addCourse(course2);
//		EntityManager em = EntityManagerHelper.getCurrent();
//		em.getTransaction().begin();
//		em.persist(student);
//		em.getTransaction().commit();
//		em.close();
//
//	}

	public Student load(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		EntityGraph<Student> graph = em.createEntityGraph(Student.class);
		graph.addAttributeNodes("courselist");

		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", graph);

		return em.find(Student.class, studentid, properties);
	}
}
