package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.ds.JndiDs;
import web_erp.dto.Department;
import web_erp.dto.Title;
import web_erp.impl.DepartmentDaoImpl;

public class DeptService {
	private Connection con = JndiDs.getConnection();
	private DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();

	public DeptService() {
		dao.setCon(con);
	}

	public List<Department> showDepartments() {
		return dao.selectDepartmentByAll();
	}

	public void addDepartment(Department department) {
		dao.insertDepartment(department);
	}
	
	public Department showDept(Department department) {
		return dao.selectDepartmentByNo(department);
	}
	
	public void upDept(Department department) {
		dao.updateDepartment(department);
	}
	
	public void delDept(int department) {
		dao.deleteDepartment(department);
	}

}
