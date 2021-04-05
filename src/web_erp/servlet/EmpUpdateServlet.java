package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.dto.Employee;
import web_erp.dto.Title;
import web_erp.service.EmpService;

@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;

	public EmpUpdateServlet() {
		service = new EmpService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int empno = Integer.parseInt(request.getParameter("empno").trim());
		String empname = request.getParameter("empname");
		Title title = new Title(Integer.parseInt(request.getParameter("title").trim()));
		Employee manager = new Employee(Integer.parseInt(request.getParameter("manager").trim()));
		int salary = Integer.parseInt(request.getParameter("salary").trim());
		Department dept = new Department(Integer.parseInt(request.getParameter("dept").trim()));

		Employee upEmp = new Employee(empno, empname, title, manager, salary, dept);
		service.upEmp(upEmp);
		response.sendRedirect("EmployeeServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
