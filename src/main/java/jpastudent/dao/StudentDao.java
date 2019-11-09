package jpastudent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpastudent.model.Student;

public class StudentDao {

	public boolean addStudent(Student student){
		boolean flag= false;
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu");
			EntityManager em= emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
			flag= true;
			
		}catch(Exception e){
			System.out.println(e);
		}
		return flag;
	}
	public List<Student> displayStudents(){
		List<Student> slist = new ArrayList<Student>();
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("from Student");
			slist = query.getResultList();
		}catch(Exception e){
			System.out.println(e);
		}
		return slist;
	}
	public boolean deleteStudent(Student student){
		boolean flag = false;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, student.getRollno());
			em.remove(s);
			em.getTransaction().commit();
			flag=true;
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
}
