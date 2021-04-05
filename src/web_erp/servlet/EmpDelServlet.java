package web_erp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Employee;
import web_erp.service.EmpService;

@WebServlet("/EmpDelServlet")
public class EmpDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
       
    public EmpDelServlet() {
    	service = new EmpService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int empNo = Integer.parseInt(request.getParameter("empno").trim());
		
		Employee delEmp = new Employee(empNo);
		
		service.delEmp(empNo);
		response.sendRedirect("EmployeeServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
