package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.service.DeptService;

@WebServlet("/DeptUpdateServlet")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService service;

	public DeptUpdateServlet() {
		service= new DeptService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int no =Integer.parseInt(request.getParameter("deptno").trim());
		String name = request.getParameter("deptname").trim();
		int floor =Integer.parseInt(request.getParameter("floor").trim());
		
		Department department = new Department(no,name,floor);
		
		service.upDept(department);
		response.sendRedirect("DeptServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
