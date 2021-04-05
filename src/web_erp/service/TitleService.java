package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.ds.JndiDs;
import web_erp.dto.Title;
import web_erp.impl.TitleDaoimpl;

public class TitleService {
	private Connection con = JndiDs.getConnection();
	private TitleDaoimpl dao = TitleDaoimpl.getInstance();
	
	public TitleService() {
		dao.setCon(con);
	}
	
	public List<Title> showTitles(){
	return dao.selectTitleByAll();
	}
	
	public void addTitle(Title title) {
		dao.insertTitle(title);
	}
	
	public void upTitle(Title title) {
		dao.updateTitle(title);
	}
	
	public void delTitle(int title) {
		dao.deleteTitle(title);
	}
	
	public Title showTitle(Title title) {
		return dao.selectTitleByNo(title);
	}

}
