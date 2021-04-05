package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.ds.JndiDs;
import web_erp.dto.Department;
import web_erp.dto.Employee;
import web_erp.impl.EmployeeDaoImpl;

public class EmpService {
	private Connection con = JndiDs.getConnection();
	private EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	public EmpService() {
		dao.setCon(con);
	}

	public List<Employee> showEmployees() {
		return dao.selectEmployeeByAll();
	}
	
	public List<Employee> showEmpListByDeptNo(Department department){
		return dao.selectEmployeeBydeptNo(department);
	}
	
	public Employee showEmp(Employee emp) {
		return dao.selectEmployeeByNo(emp);
	}
	
	public void addEmp(Employee emp) {
		dao.insertEmployee(emp);
	}
	
	public void upEmp(Employee employee) {
		dao.updateEmployee(employee);
	}
	
	public void delEmp(int empNo) {
		dao.deleteEmployee(empNo);
	}
}
