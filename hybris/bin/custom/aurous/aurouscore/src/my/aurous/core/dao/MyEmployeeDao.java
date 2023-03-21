package my.aurous.core.dao;

import my.aurous.core.model.MyEmployeeModel;

import java.util.List;

public interface MyEmployeeDao
{
	public List<MyEmployeeModel> getMyEmployeeDetails();
	public List<MyEmployeeModel> getSpecificMyEmployeeDetails(final String empId);
	public void createEmployee(MyEmployeeModel myEmployeeModel);
	public void removeEmployee(List<MyEmployeeModel> employee);
	public void replaceEmployee(MyEmployeeModel employee, final String empId);
	public void updateEmployeeSalary(final String empId, final Double salary);
}
