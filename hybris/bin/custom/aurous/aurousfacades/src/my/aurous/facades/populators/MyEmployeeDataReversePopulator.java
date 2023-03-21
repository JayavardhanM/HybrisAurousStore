package my.aurous.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import my.aurous.core.model.MyEmployeeModel;
import my.aurous.facades.product.data.MyEmployeeData;

public class MyEmployeeDataReversePopulator implements Populator<MyEmployeeData, MyEmployeeModel>
{

    private static final Logger LOG = Logger.getLogger(MyEmployeeDataPopulator.class);

    @Override
    public void populate(final MyEmployeeData source, final MyEmployeeModel target) throws ConversionException
    {
        LOG.info("########## MyEmployeeDetailsDataPopulator ###########");
        Assert.notNull(source, "Parameter source can not be null");
        Assert.notNull(target, "Parameter target can not be null");
        target.setEmpId(source.getEmpId());
        target.setEmpName(source.getEmpName());
        target.setEmpSalary(source.getEmpSalary());
        target.setEmpWorkType(source.getEmpWorkType());
    }

}
