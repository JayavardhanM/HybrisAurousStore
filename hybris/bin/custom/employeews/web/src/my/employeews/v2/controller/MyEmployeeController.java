package my.employeews.v2.controller;

import de.hybris.platform.commercewebservicescommons.dto.employee.MyEmployeeDataListWSDTO;
import de.hybris.platform.commercewebservicescommons.dto.employee.MyEmployeeDataWSDTO;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import de.hybris.platform.webservicescommons.swagger.ApiFieldsParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import my.aurous.facades.employee.MyEmployeeFacade;
import my.aurous.facades.product.data.MyEmployeeData;
import my.employeews.queues.data.MyEmployeeDataList;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/aurous/en")
@Api(tags = "MyEmployee")
public class MyEmployeeController extends BaseCommerceController
{

    private static final String EMPLOYEE_MAPPING = "empId,empName,empSalary,empWorkType";
    public static final String EMPLOYEE_DOES_NOT_EXIST = "Employee with given id: '%s' doesn't exist";
    private static final String OBJECT_NAME_EMPLOYEE_ID = "empId";

    private static final Logger LOGGER = Logger.getLogger(MyEmployeeController.class);

    @Resource(name = "myEmployeeFacade")
    private MyEmployeeFacade myEmployeeFacade;

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{empId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(nickname = "getSpecificEmployeeDetails", value = "Get a Specific Employee Details",
                    notes = "Return a specific Employee based on employeeId",
                    authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public MyEmployeeDataListWSDTO getSpecificEmployeeDetails(
        @ApiParam(value = "empId", required = true)
        @PathVariable
        final String empId,@ApiParam(value = "Response configuration. This is the list of fileds that should be returned in the response body",
                                        allowableValues = "BASIC,DEFAULT,FULL")
        @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        LOGGER.info("Employee ID is " + empId);
        final MyEmployeeDataList myEmployeeDataList = new MyEmployeeDataList();
        myEmployeeDataList.setMyEmployee(myEmployeeFacade.getSpecificEmployeeDetails(empId));
        return getDataMapper().map(myEmployeeDataList, MyEmployeeDataListWSDTO.class);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
    @ApiOperation(nickname = "removeEmployee", value = "Delete employee",
            notes = "Removes employee",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    @ResponseStatus(HttpStatus.OK)
    public void removeEmployee(@ApiParam(value = "Employee identifier.", required = true) @PathVariable final String empId)
    {
        LOGGER.info("removeEmployee: id = " + empId);
        getMyEmployeeFacade().removeEmployee(empId);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/allemployees", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(nickname = "getAllEmployeeDetails", value = "Get a data of All Employee Details",
            notes = "Return a data of All Employees",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    public MyEmployeeDataListWSDTO getAllEmployeeDetails()
    {
        LOGGER.info("Employees Data");
        final MyEmployeeDataList myEmployeeDataList = new MyEmployeeDataList();
        myEmployeeDataList.setMyEmployee(myEmployeeFacade.getMyEmployeeDetails());
        return getDataMapper().map(myEmployeeDataList, MyEmployeeDataListWSDTO.class);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(nickname = "createEmployee", value = "Create an Employee",
            notes = "Create an Employee",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public MyEmployeeDataWSDTO createEmployee(
            @ApiParam(value = "Employee object", required = true) @RequestBody final MyEmployeeDataWSDTO employee,
            @ApiFieldsParam @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        final MyEmployeeData employeeData = getDataMapper().map(employee, MyEmployeeData.class, EMPLOYEE_MAPPING);
        getMyEmployeeFacade().createEmployee(employeeData);
        return getDataMapper().map(employeeData, MyEmployeeDataWSDTO.class, fields);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{empId}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "replaceEmployee", value = "Updates employee details", notes = "Updates employee details.",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public void replaceEmployee(@ApiParam(value = "Employee ID.", required = true) @PathVariable final String empId,
                                @ApiParam(value = "Employee object.", required = true) @RequestBody final MyEmployeeDataWSDTO employee)
    {
        if (getMyEmployeeFacade().getSpecificEmployeeDetails(empId).isEmpty())
        {
            LOGGER.error("Employee Not Found");
        }
        else
        {
            final MyEmployeeData employeeData = getDataMapper().map(employee, MyEmployeeData.class, EMPLOYEE_MAPPING);
            getMyEmployeeFacade().replaceEmployee(employeeData, empId);
        }
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{empId}/{salary}", method = RequestMethod.PATCH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "UpdateEmployee", value = "Updates employee salary", notes = "Updates employee salary.",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public void replaceEmployee(@ApiParam(value = "Employee ID.", required = true) @PathVariable final String empId,
                                @ApiParam(value = "Employee New Salary.", required = true) @PathVariable final Double salary)
    {
        if (getMyEmployeeFacade().getSpecificEmployeeDetails(empId).isEmpty())
        {
            LOGGER.error("Employee Not Found");
        }
        else
        {
            getMyEmployeeFacade().updateEmployeeSalary(empId, salary);
        }
    }

    public MyEmployeeFacade getMyEmployeeFacade() {
        return myEmployeeFacade;
    }

    public void setMyEmployeeFacade(MyEmployeeFacade myEmployeeFacade) {
        this.myEmployeeFacade = myEmployeeFacade;
    }
}
