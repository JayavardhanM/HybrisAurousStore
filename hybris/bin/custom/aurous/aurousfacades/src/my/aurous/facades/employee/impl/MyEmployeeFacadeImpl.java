package my.aurous.facades.employee.impl;

import de.hybris.platform.commercefacades.i18n.comparators.CountryComparator;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commerceservices.enums.CountryType;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import my.aurous.core.enums.WorkTypeEnumeration;
import my.aurous.core.model.MyEmployeeModel;
import my.aurous.core.service.MyEmployeeService;
import my.aurous.facades.employee.MyEmployeeFacade;
import my.aurous.facades.populators.MyEmployeeDataReversePopulator;
import my.aurous.facades.product.data.MyEmployeeData;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyEmployeeFacadeImpl implements MyEmployeeFacade
{
	private MyEmployeeService myEmployeeService;
	private ModelService modelService;
	private MyEmployeeDataReversePopulator myEmployeeDataReversePopulator;
	@Resource(name = "myEmployeeDataConverter")
	private Converter<MyEmployeeModel, MyEmployeeData> myEmployeeDataConverter;

	private static final Logger LOG = Logger.getLogger(MyEmployeeFacadeImpl.class);

	@Override
	public List<MyEmployeeData> getMyEmployeeDetails()
	{
		LOG.info("######### MyEmployeeFacadeImpl #############");
		final List<MyEmployeeData> employees = new ArrayList<MyEmployeeData>();
		final List<MyEmployeeModel> model = getMyEmployeeService().getMyEmployeeDetails();
		final List<MyEmployeeData> myEmployeeData = myEmployeeDataConverter.convertAll(model);
		employees.addAll(myEmployeeData);
		return employees;
	}

	@Override
	public List<MyEmployeeData> getSpecificEmployeeDetails(final String empId)
	{
		LOG.info("######### MyEmployeeFacadeImpl #############");
		final List<MyEmployeeData> employee = new ArrayList<MyEmployeeData>();
		final List<MyEmployeeModel> model = getMyEmployeeService().getSpecificMyEmployeeDetails(empId);
		final List<MyEmployeeData> myEmployeeData = myEmployeeDataConverter.convertAll(model);
		employee.addAll(myEmployeeData);
		return employee;
	}

	@Override
	public void createEmployee(MyEmployeeData myEmployeeData)
	{
		LOG.info("######### MyEmployeeFacadeImpl #############");
		final MyEmployeeModel myEmployeeModel = getModelService().create(MyEmployeeModel.class);
		getMyEmployeeDataReversePopulator().populate(myEmployeeData, myEmployeeModel);
		getMyEmployeeService().createEmployee(myEmployeeModel);
	}

	@Override
	public void removeEmployee(final String empId)
	{
		LOG.info("######### MyEmployeeFacadeImpl #############");
		getMyEmployeeService().removeEmployee(empId);
	}

	@Override
	public void replaceEmployee(final MyEmployeeData myEmployeeData, final String empId)
	{
		LOG.info("######### MyEmployeeFacadeImpl #############");
		final MyEmployeeModel myEmployeeModel = getModelService().create(MyEmployeeModel.class);
		getMyEmployeeDataReversePopulator().populate(myEmployeeData, myEmployeeModel);
		getMyEmployeeService().replaceEmployee(myEmployeeModel, empId);
	}

	@Override
	public void updateEmployeeSalary(final String empId, final Double salary)
	{
		LOG.info("######### MyEmployeeFacadeImpl #############");
		getMyEmployeeService().updateEmployeeSalary(empId, salary);
	}

	public MyEmployeeService getMyEmployeeService() {
		return myEmployeeService;
	}

	public void setMyEmployeeService(MyEmployeeService myEmployeeService) {
		this.myEmployeeService = myEmployeeService;
	}

	public ModelService getModelService() {
		return modelService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	public MyEmployeeDataReversePopulator getMyEmployeeDataReversePopulator() {
		return myEmployeeDataReversePopulator;
	}

	public void setMyEmployeeDataReversePopulator(MyEmployeeDataReversePopulator myEmployeeDataReversePopulator) {
		this.myEmployeeDataReversePopulator = myEmployeeDataReversePopulator;
	}

	public Converter<MyEmployeeModel, MyEmployeeData> getMyEmployeeDataConverter() {
		return myEmployeeDataConverter;
	}

	public void setMyEmployeeDataConverter(Converter<MyEmployeeModel, MyEmployeeData> myEmployeeDataConverter) {
		this.myEmployeeDataConverter = myEmployeeDataConverter;
	}
}
