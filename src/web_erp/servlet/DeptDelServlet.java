package web_erp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.dto.Title;
import web_erp.service.DeptService;
import web_erp.service.TitleService;

/**
 * Servlet implementation class DeptDelServlet
 */
@WebServlet("/DeptDelServlet")
public class DeptDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService service;
    public DeptDelServlet() {
    	service = new DeptService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int deptno = Integer.parseInt(request.getParameter("deptNo").trim());
		
		Department dept = new Department(deptno);
		System.out.println(dept);
		
		service.delDept(deptno);
		response.sendRedirect("DeptServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
