package my.aurous.core.service;

import java.util.List;

import my.aurous.core.enums.WorkTypeEnumeration;
import my.aurous.core.model.MyEmployeeModel;
import my.aurous.facades.product.data.MyEmployeeData;

public interface MyEmployeeService
{
	public List<MyEmployeeModel> getMyEmployeeDetails();
	public List<MyEmployeeModel> getSpecificMyEmployeeDetails(final String empId);
	public void createEmployee(MyEmployeeModel myEmployeeModel);
	public void removeEmployee(final String empId);
	public void replaceEmployee(MyEmployeeModel employee, final String empId);
	public void updateEmployeeSalary(final String empId, final Double salary);

}
