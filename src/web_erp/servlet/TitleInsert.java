package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Title;
import web_erp.service.TitleService;

/**
 * Servlet implementation class TitleInsert
 */
@WebServlet("/jsp_13/titleInsert")
public class TitleInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleService service;

	public TitleInsert() {
		service = new TitleService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int tNo = Integer.parseInt(request.getParameter("tno").trim());
		String tName = request.getParameter("tname").trim();

		Title title = new Title(tNo, tName);
		service.addTitle(title);

		response.sendRedirect("/web_basic/titleServlet");
	}

}
