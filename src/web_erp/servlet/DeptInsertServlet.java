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

@WebServlet("/DeptInsertServlet")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService service;

	public DeptInsertServlet() {
		service = new DeptService();
	}

	// 0403 여기서 ㅇ부터 insert 마무리 하기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int deptno = Integer.parseInt(request.getParameter("deptno").trim());
		String deptname = request.getParameter("deptname");
		int floor = Integer.parseInt(request.getParameter("floor").trim());

		Department dept = new Department(deptno, deptname, floor);
		System.out.println(dept);

		service.addDepartment(dept);
		response.sendRedirect("DeptServlet");
//	      request.getRequestDispatcher("TitleListServlet").forward(request, response);
	}

}
