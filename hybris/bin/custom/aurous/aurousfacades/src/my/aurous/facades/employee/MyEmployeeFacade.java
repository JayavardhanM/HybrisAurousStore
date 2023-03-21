package my.aurous.facades.employee;

import java.util.Collections;
import java.util.List;

import de.hybris.platform.commercefacades.i18n.comparators.CountryComparator;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commerceservices.enums.CountryType;
import my.aurous.core.enums.WorkTypeEnumeration;
import my.aurous.core.model.MyEmployeeModel;
import my.aurous.facades.product.data.MyEmployeeData;

public interface MyEmployeeFacade
{
	public List<MyEmployeeData> getMyEmployeeDetails();
	public List<MyEmployeeData> getSpecificEmployeeDetails(final String empId);
	public void createEmployee(final MyEmployeeData myEmployeeData);
	public void removeEmployee(final String empId);
	public void replaceEmployee(final MyEmployeeData myEmployeeData, final String empId);
	public void updateEmployeeSalary(final String empId, final Double salary);

}
