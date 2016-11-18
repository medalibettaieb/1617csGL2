package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.cs.g2.entities.Course;
import tn.esprit.cs.g2.services.CourseManagementLocal;

/**
 * Servlet implementation class MyFirstServlet
 */
public class MyFirstServlet extends HttpServlet {
	@EJB
	private CourseManagementLocal courseManagementLocal;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String nameCourse = request.getParameter("nameC");
		String idTeacher = request.getParameter("idT");

		Course course = new Course();
		course.setName(nameCourse);
		courseManagementLocal.addCourseWithTeacher(course, Integer.parseInt(idTeacher));

		Date date = new Date();
		printWriter.write("<html><body><h1><font color='red'>hello " + nameCourse + "</font></h1><br>" + "it is = "
				+ date + "" + "</body></html>");

	}

}
