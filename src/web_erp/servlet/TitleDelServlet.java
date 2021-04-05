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
 * Servlet implementation class TitleDelServlet
 */
@WebServlet("/TitleDelServlet")
public class TitleDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleService service;
       
    public TitleDelServlet() {
    	service = new TitleService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no").trim());
		
		Title title = new Title(no);
		System.out.println(title);
		
		service.delTitle(no);
		response.sendRedirect("TitleServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
