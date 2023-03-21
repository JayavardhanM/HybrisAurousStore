package my.aurous.core.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import org.apache.log4j.Logger;

import my.aurous.core.model.MyEmployeeModel;


public class MyEmployeeValidateInterceptor implements ValidateInterceptor<MyEmployeeModel>
{

	private static final Logger LOG = Logger.getLogger(MyEmployeeValidateInterceptor.class);

	@Override
	public void onValidate(final MyEmployeeModel myEmployee, final InterceptorContext ctx) throws InterceptorException
	{
		LOG.info("######## MyEmployeeValidateInterceptor ########");
		if (myEmployee.getEmpSalary() < 5000)
		{
			throw new InterceptorException("Employee cannot have Salary greater than 5000");
		}
	}
}
