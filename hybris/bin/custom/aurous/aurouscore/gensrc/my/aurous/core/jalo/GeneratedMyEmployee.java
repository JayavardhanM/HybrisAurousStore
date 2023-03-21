/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 04-Jan-2023, 5:52:39 pm                     ---
 * ----------------------------------------------------------------
 */
package my.aurous.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import my.aurous.core.constants.AurousCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem MyEmployee}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedMyEmployee extends GenericItem
{
	/** Qualifier of the <code>MyEmployee.empId</code> attribute **/
	public static final String EMPID = "empId";
	/** Qualifier of the <code>MyEmployee.empName</code> attribute **/
	public static final String EMPNAME = "empName";
	/** Qualifier of the <code>MyEmployee.empSalary</code> attribute **/
	public static final String EMPSALARY = "empSalary";
	/** Qualifier of the <code>MyEmployee.empWorkType</code> attribute **/
	public static final String EMPWORKTYPE = "empWorkType";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(EMPID, AttributeMode.INITIAL);
		tmp.put(EMPNAME, AttributeMode.INITIAL);
		tmp.put(EMPSALARY, AttributeMode.INITIAL);
		tmp.put(EMPWORKTYPE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empId</code> attribute.
	 * @return the empId - Employee ID
	 */
	public String getEmpId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMPID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empId</code> attribute.
	 * @return the empId - Employee ID
	 */
	public String getEmpId()
	{
		return getEmpId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empId</code> attribute. 
	 * @param value the empId - Employee ID
	 */
	public void setEmpId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMPID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empId</code> attribute. 
	 * @param value the empId - Employee ID
	 */
	public void setEmpId(final String value)
	{
		setEmpId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empName</code> attribute.
	 * @return the empName - Employee Name
	 */
	public String getEmpName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMPNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empName</code> attribute.
	 * @return the empName - Employee Name
	 */
	public String getEmpName()
	{
		return getEmpName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empName</code> attribute. 
	 * @param value the empName - Employee Name
	 */
	public void setEmpName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMPNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empName</code> attribute. 
	 * @param value the empName - Employee Name
	 */
	public void setEmpName(final String value)
	{
		setEmpName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empSalary</code> attribute.
	 * @return the empSalary - Employee salary
	 */
	public Double getEmpSalary(final SessionContext ctx)
	{
		return (Double)getProperty( ctx, EMPSALARY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empSalary</code> attribute.
	 * @return the empSalary - Employee salary
	 */
	public Double getEmpSalary()
	{
		return getEmpSalary( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empSalary</code> attribute. 
	 * @return the empSalary - Employee salary
	 */
	public double getEmpSalaryAsPrimitive(final SessionContext ctx)
	{
		Double value = getEmpSalary( ctx );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empSalary</code> attribute. 
	 * @return the empSalary - Employee salary
	 */
	public double getEmpSalaryAsPrimitive()
	{
		return getEmpSalaryAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empSalary</code> attribute. 
	 * @param value the empSalary - Employee salary
	 */
	public void setEmpSalary(final SessionContext ctx, final Double value)
	{
		setProperty(ctx, EMPSALARY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empSalary</code> attribute. 
	 * @param value the empSalary - Employee salary
	 */
	public void setEmpSalary(final Double value)
	{
		setEmpSalary( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empSalary</code> attribute. 
	 * @param value the empSalary - Employee salary
	 */
	public void setEmpSalary(final SessionContext ctx, final double value)
	{
		setEmpSalary( ctx,Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empSalary</code> attribute. 
	 * @param value the empSalary - Employee salary
	 */
	public void setEmpSalary(final double value)
	{
		setEmpSalary( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empWorkType</code> attribute.
	 * @return the empWorkType - Employee Work Type
	 */
	public EnumerationValue getEmpWorkType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, EMPWORKTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyEmployee.empWorkType</code> attribute.
	 * @return the empWorkType - Employee Work Type
	 */
	public EnumerationValue getEmpWorkType()
	{
		return getEmpWorkType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empWorkType</code> attribute. 
	 * @param value the empWorkType - Employee Work Type
	 */
	public void setEmpWorkType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, EMPWORKTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyEmployee.empWorkType</code> attribute. 
	 * @param value the empWorkType - Employee Work Type
	 */
	public void setEmpWorkType(final EnumerationValue value)
	{
		setEmpWorkType( getSession().getSessionContext(), value );
	}
	
}
