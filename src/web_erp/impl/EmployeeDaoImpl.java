package web_erp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_erp.dao.EmployeeDao;
import web_erp.dto.Department;
import web_erp.dto.Employee;
import web_erp.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	private Connection con;

	public static EmployeeDaoImpl getInstance() {
		return instance;
	}

	private EmployeeDaoImpl() {
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	// -------------------------------------------------------------------------

	@Override
	public List<Employee> selectEmployeeByAll() {
		String sql = "select empno ,empname, title_no, title_name, manager_no, manager_name, salary, deptno, deptname, floor from vw_full_employee ";
		try (PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");
		String empName = rs.getString("empname");
		Title title = new Title(rs.getInt("title_no"));
		Employee manager = new Employee(rs.getInt("manager_no"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("deptno"));

		try {
			title.setName(rs.getString("title_name"));
		} catch (SQLException e) {
		}

		try {
			manager.setEmpName(rs.getString("manager_name"));
		} catch (SQLException e) {
		}

		try {
			dept.setDeptName(rs.getString("deptname"));
		} catch (SQLException e) {
		}

		/*
		 * if(rs.getString("title_name") != null ) {
		 * title.settName(rs.getString("title_name")); }
		 * 
		 * if(rs.getNString("manager_name") != null) {
		 * manager.setEmpName(rs.getString("manager_name")); }
		 * 
		 * if (rs.getString("deptname")!=null && rs.getInt("floor") != 0) {
		 * dept.setDeptName(rs.getNString("deptname"));
		 * dept.setFloor(rs.getInt("floor")); }
		 */
		return new Employee(empNo, empName, title, manager, salary, dept);
	}

	// -------------------------------------------------------------------------

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo  from employee e where empno = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, employee.getEmpNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "insert into employee values(?,?,?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, employee.getEmpNo());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setInt(3, employee.getTitle().getNo()); // title
			pstmt.setInt(4, employee.getManager().getEmpNo()); // manager
			pstmt.setInt(5, employee.getSalary()); // salary
			pstmt.setInt(6, employee.getDept().getDeptNo()); // dept
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employee set empName = ? where empNo = ? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, employee.getEmpName());
			pstmt.setInt(2, employee.getEmpNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int EmployeeNo) {
		String sql = "delete from employee where empNo = ? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, EmployeeNo);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Employee> selectEmployeeBydeptNo(Department department) {
		String sql = "select empno, empname, title, manager, salary,dept from employee where dept = (select deptNo from department where deptno= ?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, department.getDeptNo());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Employee> list = new ArrayList<>();
					do {
						list.add(getEmployee2(rs));

					} while (rs.next());
					return list;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee2(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");
		String empName = rs.getString("empname");
		Title title = new Title(rs.getInt("title"));
		Employee manager = new Employee(rs.getInt("manager"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("dept"));

		return new Employee(empNo, empName, title, manager, salary, dept);
	}
}
