package jpastudent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpastudent.dao.StudentDao;
import jpastudent.model.Student;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String course = request.getParameter("course");
		String result = request.getParameter("result");
		
		Student student = new Student(rollno, fname, lname, course, result);
		boolean flag  = new StudentDao().addStudent(student);
		if(flag){
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("Register.jsp");
		}
	}

}
